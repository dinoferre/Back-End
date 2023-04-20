package com.dinoferre.portfolio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinoferre.portfolio.Entity.ExperienciaEntity;

public interface IExperienciaRepository extends JpaRepository <ExperienciaEntity, Long>{
	
	public Optional<ExperienciaEntity> findByNombreE(String nombreE);

	public boolean existsByNombreE(String nombreE);

}
