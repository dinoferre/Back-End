package com.dinoferre.portfolio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Entity.ExperienciaEntity;
import com.dinoferre.portfolio.Repository.IExperienciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExperienciaService {

	@Autowired
	IExperienciaRepository iExperienciaRepository;

	// Arma una lista con todas las experiencias que encuentre
	public List<ExperienciaEntity> list() {
		return iExperienciaRepository.findAll();
	}

	// Buscar una experiencia en particular por id (utilizo el optional ya que puede
	// estar y no)
	public Optional<ExperienciaEntity> getOne(long id) {
		return iExperienciaRepository.findById(id);
	}

	// Buscar por nombre de experiencia
	public Optional<ExperienciaEntity> getByNombreE(String nombreE) {
		return iExperienciaRepository.findByNombreE(nombreE);
	}

	// Guardar un objeto de tipo ExperienciaEntity
	public void save(ExperienciaEntity expe) {
		iExperienciaRepository.save(expe);
	}

	// Borrar por id
	public void delete(long id) {
		iExperienciaRepository.deleteById(id);
	}

	// Existe? por id. (es un booleano ya que devuelve true o false)
	public boolean existsById(long id) {
		return iExperienciaRepository.existsById(id);
	}

	// Existe? por nombre
	public boolean existsByNombreE(String nombreE) {
		return iExperienciaRepository.existsByNombreE(nombreE);
	}

	public Optional<ExperienciaEntity> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
