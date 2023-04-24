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

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
