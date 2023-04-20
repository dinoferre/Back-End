/**
 * La clase ImpPersonaService es un componente de servicio de Spring que se utiliza para implementar la lógica 
 * de negocio relacionada con las entidades de persona y utiliza una única transacción de base de datos para 
 * todas las operaciones de base de datos realizadas dentro de los métodos de la clase. La clase implementa la 
 * interfaz IPersonaService e incluye cuatro métodos que definen la lógica de negocio necesaria para interactuar 
 * con las entidades de persona. La instancia de IPersonaRepository se inyecta automáticamente en la clase 
 * mediante @Autowired
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Entity.PersonaEntity;
import com.dinoferre.portfolio.Interface.IPersonaService;
import com.dinoferre.portfolio.Repository.IPersonaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImpPersonaService implements IPersonaService {
	
	@Autowired
	private IPersonaRepository personaRepository;

	@Override
	public List<PersonaEntity> getPersona() {
		List<PersonaEntity> listaPersonas = personaRepository.findAll();
		return listaPersonas;
	}

	@Override
	public void savePersona(PersonaEntity perso) {
		personaRepository.save(perso);
	}

	@Override
	public void deletePersona(Long id) {
		personaRepository.deleteById(id);		
	}

	@Override
	public PersonaEntity findPersona(Long id) {
		PersonaEntity perso = personaRepository.findById(id).orElse(null);
		return perso;
	}
	
}