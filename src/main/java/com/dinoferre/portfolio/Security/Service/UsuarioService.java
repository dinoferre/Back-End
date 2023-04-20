package com.dinoferre.portfolio.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Security.Entity.Usuario;
import com.dinoferre.portfolio.Security.Repository.IUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	IUsuarioRepository iUsuarioRepository;

	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
	}

	public boolean existsByNombreUsuario(String nombreUsuario) {
		return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
	}

	public boolean existsByEmail(String email) {
		return iUsuarioRepository.existsByEmail(email);
	}

	public void save(Usuario usuario) {
		iUsuarioRepository.save(usuario);
	}

}