package com.dinoferre.portfolio.DTO;

import jakarta.validation.constraints.NotBlank;

public class ExperienciaDTO {

	// Atributos
	@NotBlank
	private String nombreE;
	@NotBlank
	private String descripcionE;

	// Constructor vacio y con parámetros
	public ExperienciaDTO() {

	}

	public ExperienciaDTO(@NotBlank String nombreE, @NotBlank String descripcionE) {
		this.nombreE = nombreE;
		this.descripcionE = descripcionE;
	}

	// Get & Set
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
