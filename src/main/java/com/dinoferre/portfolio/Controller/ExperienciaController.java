/**
 * Este código define un controlador de Spring MVC utilizando la anotación @RestController, 
 * que indica que esta clase es un controlador y que las respuestas HTTP generadas serán mapeadas directamente 
 * al cuerpo de la respuesta en lugar de a una vista. También utiliza la anotación @RequestMapping para definir 
 * una ruta base para todas las solicitudes que maneja.
 * 
 * El controlador maneja solicitudes HTTP para manejar la creación, actualización, eliminación y recuperación 
 * de experiencias laborales a través de las rutas /explaboral/crear, /explaboral/update/{id}, 
 * /explaboral/delete/{id}, /explaboral/lista y /explaboral/detail/{id}. 
 * La anotación @CrossOrigin se utiliza para permitir solicitudes desde el origen http://localhost:4200.
 * 
 * El controlador utiliza la clase ExperienciaService para realizar operaciones de base de datos, como guardar, 
 * actualizar, eliminar y buscar experiencias laborales. Los datos se pasan al controlador como objetos JSON 
 * utilizando la anotación @RequestBody. El controlador también utiliza la clase Mensaje para devolver mensajes 
 * de error o éxito al cliente. * 
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinoferre.portfolio.DTO.ExperienciaDTO;
import com.dinoferre.portfolio.Entity.ExperienciaEntity;
import com.dinoferre.portfolio.Security.Controller.Mensaje;
import com.dinoferre.portfolio.Service.ExperienciaService;

@RestController
@RequestMapping("/explaboral")
@CrossOrigin(origins = {"https://front-end-dino.web.app","http://localhost:4200"})
public class ExperienciaController {

	@Autowired
	ExperienciaService experienciaService;

	@GetMapping("/lista")
	public ResponseEntity<List<ExperienciaEntity>> list() {
		List<ExperienciaEntity> list = experienciaService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<ExperienciaEntity> getById(@PathVariable("id") int id) {
		if (!experienciaService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
		}

		ExperienciaEntity experiencia = experienciaService.getOne(id).get();
		return new ResponseEntity(experiencia, HttpStatus.OK);
	}	
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!experienciaService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
		}
		experienciaService.delete(id);
		return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ExperienciaDTO experienciaDTO) {
		if (StringUtils.isBlank(experienciaDTO.getNombreE())) {
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}
		if (experienciaService.existsByNombreE(experienciaDTO.getNombreE())) {
			return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
		}

		ExperienciaEntity experienciaEntity = new ExperienciaEntity(experienciaDTO.getNombreE(), 
				experienciaDTO.getDescripcionE());
		experienciaService.save(experienciaEntity);
		
		return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDTO experienciaDTO) {
		if (!experienciaService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
		}
		if (experienciaService.existsByNombreE(experienciaDTO.getNombreE())
				&& experienciaService.getByNombreE(experienciaDTO.getNombreE()).get().getId() != id) {
			return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isBlank(experienciaDTO.getNombreE())) {
			return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
		}

		ExperienciaEntity experienciaEntity = experienciaService.getOne(id).get();

		experienciaEntity.setNombreE(experienciaDTO.getNombreE());
		experienciaEntity.setDescripcionE(experienciaDTO.getDescripcionE());

		experienciaService.save(experienciaEntity);

		return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
	}

}