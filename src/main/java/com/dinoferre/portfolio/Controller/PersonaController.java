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
	public PersonaEntity editPersona(@PathVariable Long id,
							   @RequestParam("nombre") String nuevoNombre,
							   @RequestParam("apellido") String nuevoApellido,
							   @RequestParam("imagen") String nuevaImagen) {
		
		PersonaEntity perso = interPersona.findPersona(id);
		
		perso.setNombre(nuevoNombre);
		perso.setApellido(nuevoApellido);
		perso.setImagen(nuevaImagen);
		
		interPersona.savePersona(perso);
		
		return perso;
	}
	
	@GetMapping("/personas/traer/perfil")
	public PersonaEntity findPersona() {
		return interPersona.findPersona((long)1);
	}	

}