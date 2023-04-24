/**
 * El código que se resume es una clase anotada con @Entity llamada ExperienciaEntity, 
 * la cual tiene los siguientes atributos: id (tipo entero), nombreE (tipo String) y descripcionE (tipo String). 
 * También tiene un constructor vacío y otro con parámetros, así como los getters/setters.
 *
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExperienciaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombreE;
	private String descripcionE;

	public ExperienciaEntity() {
	}

	public ExperienciaEntity(String nombreE, String descripcionE) {
		this.nombreE = nombreE;
		this.descripcionE = descripcionE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreE() {
		return nombreE;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public String getDescripcionE() {
		return descripcionE;
	}

	public void setDescripcionE(String descripcionE) {
		this.descripcionE = descripcionE;
	}

}