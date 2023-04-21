/**
 * Esta clase representa un modelo de Rol con un id generado automáticamente y el nombre del rol 
 * representado por un enumerado. La anotación "@Entity" indica que esta clase se puede almacenar 
 * en una base de datos, y los métodos públicos permiten acceder y modificar los valores 
 * de las variables de instancia.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Entity;

import com.dinoferre.portfolio.Security.Enums.RolNombre;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private RolNombre rolNombre;

	public Rol() {
	}

	public Rol(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RolNombre getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}

}
