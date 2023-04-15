package com.dinoferre.portfolio.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Security.Entity.Rol;
import com.dinoferre.portfolio.Security.Enums.RolNombre;
import com.dinoferre.portfolio.Security.Repository.IRolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService {

	@Autowired
	IRolRepository iRolRepository;

	public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
		return iRolRepository.findByRolNombre(rolNombre);
	}

	public void save(Rol rol) {
		iRolRepository.save(rol);
	}
}