/**
 * Esta es la definición de una clase llamada "dtoEducacion", la cual tiene dos atributos de tipo String
 * llamados "nombreE" y "descripcionE". La clase tiene dos constructores, uno vacío y otro que recibe
 * como parámetros valores para ambos atributos. La clase también tiene dos métodos getter y setter
 * para cada uno de los atributos. Además, la anotación "@NotBlank" indica que los atributos no pueden
 * estar en blanco o nulos.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.DTO;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {
	@NotBlank
	private String nombreE;
	@NotBlank
	private String descripcionE;

	public dtoEducacion() {
	}

	public dtoEducacion(String nombreE, String descripcionE) {
		this.nombreE = nombreE;
		this.descripcionE = descripcionE;
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