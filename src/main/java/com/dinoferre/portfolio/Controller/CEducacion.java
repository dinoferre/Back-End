/**
 * Controlador REST en Java, que utiliza la anotación @RestController para indicar que la clase es un 
 * controlador y el prefijo de la URL ("/educacion") para definir el endpoint principal de la API.
 * 
 * Además, el controlador utiliza la anotación @CrossOrigin para permitir solicitudes 
 * desde un origen diferente al servidor.
 * 
 * El controlador tiene cinco métodos HTTP que corresponden a las operaciones CRUD 
 * (Crear, Leer, Actualizar, Eliminar) para una entidad Educación. * 
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

import com.dinoferre.portfolio.DTO.dtoEducacion;
import com.dinoferre.portfolio.Entity.Educacion;
import com.dinoferre.portfolio.Security.Controller.Mensaje;
import com.dinoferre.portfolio.Service.Seducacion;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://front-end-dino.web.app","http://localhost:4200"})
public class CEducacion {

	@Autowired
	Seducacion sEducacion;

	@GetMapping("/lista")
	public ResponseEntity<List<Educacion>> list() {
		List<Educacion> list = sEducacion.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
		if (!sEducacion.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
		}

		Educacion educacion = sEducacion.getOne(id).get();
		return new ResponseEntity(educacion, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!sEducacion.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
		}
		sEducacion.delete(id);
		return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion) {
		if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}
		if (sEducacion.existsByNombreE(dtoeducacion.getNombreE())) {
			return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		}

		Educacion educacion = new Educacion(dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE());
		sEducacion.save(educacion);
		return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion) {
		if (!sEducacion.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
		}
		if (sEducacion.existsByNombreE(dtoeducacion.getNombreE())
				&& sEducacion.getByNmbreE(dtoeducacion.getNombreE()).get().getId() != id) {
			return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
			return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
		}

		Educacion educacion = sEducacion.getOne(id).get();

		educacion.setNombreE(dtoeducacion.getNombreE());
		educacion.setDescripcionE(dtoeducacion.getDescripcionE());

		sEducacion.save(educacion);

		return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
	}

}