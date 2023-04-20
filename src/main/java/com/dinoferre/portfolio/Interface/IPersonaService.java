/**
 *  Interfaz que define métodos para realizar operaciones CRUD (Crear, Leer, 
 *  Actualizar, Borrar) en una entidad Persona.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Interface;

import java.util.List;

import com.dinoferre.portfolio.Entity.PersonaEntity;

public interface IPersonaService {
	
	public List<PersonaEntity> getPersona();
	
	public void savePersona(PersonaEntity perso);
	
	public void deletePersona(Long id);
	
	public PersonaEntity findPersona(Long id);

}