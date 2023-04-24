/**
 * Este código define una clase de servicio UsuarioService con anotaciones @Service y @Transactional. 
 * La clase tiene una dependencia inyectada IUsuarioRepository y proporciona varios métodos para interactuar 
 * con la base de datos.
 * 
 * El método getByNombreUsuario recupera un objeto Optional<Usuario> de la base de datos según el nombre de 
 * usuario proporcionado.
 * 
 * El método existsByNombreUsuario comprueba si existe un usuario en la base de datos con el nombre de 
 * usuario proporcionado y devuelve un valor booleano.
 * 
 * El método existsByEmail comprueba si existe un usuario en la base de datos con la dirección de correo 
 * electrónico proporcionada y devuelve un valor booleano.
 * 
 * El método save guarda un objeto Usuario en la base de datos.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Security.Entity.Usuario;
import com.dinoferre.portfolio.Security.Repository.IUsuarioRepository;

import javax.transaction.Transactional;

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