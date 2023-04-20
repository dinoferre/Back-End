package com.dinoferre.portfolio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinoferre.portfolio.Entity.PersonaEntity;

@Repository
public interface IPersonaRepository extends JpaRepository<PersonaEntity, Long> {

	public Optional<PersonaEntity> findByNombre(String nombre);

	public boolean existsByNombre(String nombre);

}

// Esta interfaz define métodos para buscar y comprobar la existencia de entidades de persona por su nombre 
// en una base de datos, y la anotación @Repository indica que se utilizará una clase específica para implementar 
// esta interfaz y gestionar las operaciones de persistencia de datos correspondientes.