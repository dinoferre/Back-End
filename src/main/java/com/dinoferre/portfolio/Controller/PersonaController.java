/**
 * Este código define un controlador REST con la anotación @RestController. 
 * También utiliza la anotación @CrossOrigin para permitir solicitudes desde un origen específico.
 * 
 * El controlador expone varios puntos finales HTTP para realizar operaciones CRUD en una entidad PersonaEntity. 
 * Las operaciones incluyen obtener una lista de todas las personas, crear una nueva persona, 
 * eliminar una persona existente y editar una persona existente.
 * 
 * El punto final @GetMapping("/personas/traer/perfil") se utiliza para obtener una sola entidad PersonaEntity 
 * con ID 1, que se utiliza como perfil de usuario. Se utiliza la anotación @PreAuthorize para limitar el acceso 
 * a las operaciones de eliminación y edición a los usuarios con el rol 'ADMIN'.
 * 
 * El controlador utiliza la interfaz IPersonaService para realizar las operaciones en la base de datos.
 * 
 * @author Dino Ferré
 **/

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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

	@Autowired
	private IPersonaService interPersona;

	@GetMapping("/personas/traer")
	public List<PersonaEntity> getPersona() {
		return interPersona.getPersona();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/personas/crear")
	public String createStudent(@RequestBody PersonaEntity perso) {
		interPersona.savePersona(perso);
		return "La persona fue creada correctamente";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/personas/delete/{id}")
	public String deletePersona(@PathVariable Long id) {
		interPersona.deletePersona(id);
		return "La persona fue eliminada correctamente";
	}

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

	@GetMapping("/personas/traer/perfil")
	public PersonaEntity findPersona() {
		return interPersona.findPersona((long) 1);
	}

}