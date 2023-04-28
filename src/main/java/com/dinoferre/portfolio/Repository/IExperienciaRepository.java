/**
 * Esta interfaz define métodos para buscar y comprobar la existencia de entidades de experiencia por su nombre 
 * en una base de datos, y la anotación @Repository indica que se utilizará una clase específica para 
 * implementar esta interfaz y gestionar las operaciones de persistencia de datos correspondientes para las 
 * entidades de experiencia en la base de datos.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinoferre.portfolio.Entity.ExperienciaEntity;

@Repository
public interface IExperienciaRepository extends JpaRepository <ExperienciaEntity, Integer>{
	
	public Optional<ExperienciaEntity> findByNombreE(String nombreE);

	public boolean existsByNombreE(String nombreE);

}