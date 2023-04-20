package com.dinoferre.portfolio.DTO;

import jakarta.validation.constraints.NotBlank;

public class ExperienciaDTO {

	@NotBlank
	private String nombreE;
	@NotBlank
	private String descripcionE;

	public ExperienciaDTO() {

	}

	public ExperienciaDTO(@NotBlank String nombreE, @NotBlank String descripcionE) {
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

// Este código define la clase ExperienciaDTO, la cual tiene dos atributos de tipo String 
// llamados nombreE y descripcionE, ambos con la anotación @NotBlank para indicar que no pueden estar vacíos. 
// También tiene dos constructores, uno vacío y otro que recibe ambos atributos como parámetros, 
// y los respectivos getters y setters para cada atributo.