/**
 * La clase LoginUsuario es un modelo que tiene dos atributos nombreUsuario y password, 
 * ambos son cadenas de texto y están anotados con la anotación @NotBlank, lo que indica que no pueden 
 * ser nulos ni vacíos. Esta clase se utiliza en el controlador para manejar la solicitud de 
 * inicio de sesión.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.DTO;

import jakarta.validation.constraints.NotBlank;

public class LoginUsuario {

	@NotBlank
	private String nombreUsuario;
	@NotBlank
	private String password;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}