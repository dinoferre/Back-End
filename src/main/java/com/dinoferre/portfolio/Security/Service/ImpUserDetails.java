/**
 * Este código muestra una clase llamada ImpUserDetails que implementa la interfaz UserDetailsService de 
 * Spring Security. Esta clase se utiliza para cargar los detalles de usuario necesarios para la autenticación 
 * y autorización en la aplicación.
 * 
 * La clase tiene una dependencia en UsuarioService, lo que indica que utiliza la capa de servicio para obtener 
 * detalles de usuario.
 * 
 * En el método loadUserByUsername(), se recibe el nombre de usuario como argumento y se utiliza usuarioService 
 * para obtener el objeto Usuario correspondiente. Luego, se construye un objeto UsuarioPrincipal a partir del 
 * objeto Usuario utilizando el método estático build() en la clase UsuarioPrincipal. Por último, se devuelve 
 * el objeto UsuarioPrincipal construido. Si no se encuentra un usuario correspondiente al nombre de usuario dado, 
 * se lanza una excepción UsernameNotFoundException.
 * 
 * La anotación @Transactional se utiliza para que Spring maneje las transacciones automáticamente.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Security.Entity.Usuario;
import com.dinoferre.portfolio.Security.Entity.UsuarioPrincipal;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImpUserDetails implements UserDetailsService {

	@Autowired
	UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
		return UsuarioPrincipal.build(usuario);

	}

}