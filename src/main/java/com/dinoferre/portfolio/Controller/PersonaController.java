package com.dinoferre.portfolio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dinoferre.portfolio.Entity.PersonaEntity;
import com.dinoferre.portfolio.Interface.IPersonaService;

//La clase PersonaController es un controlador REST que acepta solicitudes CORS desde http://localhost:4200.
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

	// Este código está utilizando la anotación @Autowired
	// para inyectar una instancia de IPersonaService en la variable interPersona.
	@Autowired
	private IPersonaService interPersona;

	// Este código define un método HTTP GET para la ruta "/personas/traer"
	// que devuelve una lista de objetos PersonaEntity.
	@GetMapping("/personas/traer")
	public List<PersonaEntity> getPersona() {
		return interPersona.getPersona();
	}

	// Este es un método POST que crea una nueva PersonaEntity y la guarda en la
	// base de datos.
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/personas/crear")
	public String createStudent(@RequestBody PersonaEntity perso) {
		interPersona.savePersona(perso);
		return "La persona fue creada correctamente";
	}

	// Este código es un método que usa la anotación @DeleteMapping para manejar una
	// solicitud HTTP DELETE
	// para eliminar una persona de la base de datos.
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/personas/delete/{id}")
	public String deletePersona(@PathVariable Long id) {
		interPersona.deletePersona(id);
		return "La persona fue eliminada correctamente";
	}

	// Este código corresponde a un método que actualiza los datos de una persona
	// existente en la base de datos,
	// a través de una petición PUT.
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/personas/editar/{id}")
	public PersonaEntity editPersona(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre,
			@RequestParam("apellido") String nuevoApellido, @RequestParam("imagen") String nuevaImagen) {

		PersonaEntity perso = interPersona.findPersona(id);

		perso.setNombre(nuevoNombre);
		perso.setApellido(nuevoApellido);
		perso.setImagen(nuevaImagen);

		interPersona.savePersona(perso);

		return perso;
	}

	// Este método obtiene una persona específica por su ID y devuelve un objeto
	// PersonaEntity.
	@GetMapping("/personas/traer/perfil")
	public PersonaEntity findPersona() {
		return interPersona.findPersona((long) 1);
	}

}