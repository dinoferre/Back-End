package com.dinoferre.portfolio.Interface;

import java.util.List;

import com.dinoferre.portfolio.Entity.PersonaEntity;

// La interfaz IPersonaService define un conjunto de métodos que deben ser implementados 
// para realizar operaciones en la entidad PersonaEntity.
public interface IPersonaService {
	
	// getPersona(): un método que devuelve una lista de todas las personas
	public List<PersonaEntity> getPersona();
	
	// savePersona(PersonaEntity perso): un método que se utiliza para guardar una nueva persona
	public void savePersona(PersonaEntity perso);
	
	// deletePersona(Long id): un método que se utiliza para eliminar una persona existente
	public void deletePersona(Long id);
	
	// findPersona(Long id): un método que se utiliza para buscar y obtener información de una persona
	public PersonaEntity findPersona(Long id);

}