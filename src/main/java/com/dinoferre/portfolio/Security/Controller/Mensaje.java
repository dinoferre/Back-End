/**
 * La clase "Mensaje" tiene un atributo "mensaje" y dos constructores, uno vacío y otro que acepta 
 * un argumento "mensaje". Además, tiene los métodos getter y setter para acceder y modificar el 
 * valor de "mensaje".
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Controller;

public class Mensaje {

	private String mensaje;

	public Mensaje() {

	}

	public Mensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
