package com.dinoferre.portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Entity.PersonaEntity;
import com.dinoferre.portfolio.Interface.IPersonaService;
import com.dinoferre.portfolio.Repository.IPersonaRepository;

@Service
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
