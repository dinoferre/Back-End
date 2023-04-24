/**
 * La clase PersonaEntity es una entidad JPA que representa una tabla de la base de datos. 
 * Tiene los siguientes atributos: id, nombre, apellido e imagen, y los métodos getters/setters correspondientes.
 * Además, cuenta con un constructor vacío y otro constructor que recibe los valores para los atributos. 
 * La anotación @Id indica que el atributo id es la clave primaria de la tabla y la anotación @GeneratedValue 
 * indica que su valor será generado automáticamente.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;
	private String apellido;
	private String imagen;

	public PersonaEntity() {

	}

	public PersonaEntity(String nombre, String apellido, String imagen) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.imagen = imagen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}