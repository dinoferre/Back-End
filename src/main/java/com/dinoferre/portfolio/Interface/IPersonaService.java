package com.dinoferre.portfolio.Interface;

import java.util.List;

import com.dinoferre.portfolio.Entity.PersonaEntity;

public interface IPersonaService {
	
	//Metodo para traer todas las personas
	public List<PersonaEntity> getPersona();
	
	//Metodo para dar de alta una persona
	public void savePersona(PersonaEntity perso);
	
	//Metodo para Borrar una persona
	public void deletePersona(Long id);
	
	//Metodo para Encontrar una persona
	public PersonaEntity findPersona(Long id);

}
