/**
 * La clase Educacion es una entidad de JPA que se utiliza para representar una tabla en la base de datos.
 * Tiene cuatro atributos: id, nombreE, descripcionE y un constructor vacío y otro con parámetros para
 * inicializar los atributos. Además, tiene los getters y setters para los atributos mencionados.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Educacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombreE;
	private String descripcionE;

	public Educacion() {
	}

	public Educacion(String nombreE, String descripcionE) {
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