/**
 * El código define una clase llamada ExperienciaService con anotaciones @Service y @Transactional. 
 * La clase utiliza la interfaz IExperienciaRepository mediante la inyección de dependencias de Spring con la 
 * anotación @Autowired.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Entity.Educacion;
import com.dinoferre.portfolio.Entity.ExperienciaEntity;
import com.dinoferre.portfolio.Repository.IExperienciaRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ExperienciaService {

	@Autowired
	IExperienciaRepository iExperienciaRepository;

	public List<ExperienciaEntity> list() {
		return iExperienciaRepository.findAll();
	}

    public Optional<ExperienciaEntity> getOne(int id){
        return iExperienciaRepository.findById(id);
    }

	public Optional<ExperienciaEntity> getByNombreE(String nombreE) {
		return iExperienciaRepository.findByNombreE(nombreE);
	}

	public void save(ExperienciaEntity expe) {
		iExperienciaRepository.save(expe);
	}

    public void delete(int id){
    	iExperienciaRepository.deleteById(id);
    }

	public boolean existsById(int id){
	     return iExperienciaRepository.existsById(id);
	}

	public boolean existsByNombreE(String nombreE) {
		return iExperienciaRepository.existsByNombreE(nombreE);
	}

}