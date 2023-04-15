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