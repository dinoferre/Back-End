/**
 * Extiende de la interfaz JpaRepository y trabaja con la entidad Usuario.
 * Define tres métodos:
 * 
 * Optional<Usuario> findByNombreUsuario(String nombreUsuario): busca un usuario por su nombre de usuario y 
 * devuelve un objeto Optional que contiene el usuario si se encuentra o un objeto vacío si no existe.
 * 
 * boolean existsByNombreUsuario(String nombreUsuario): verifica si existe un usuario con el nombre de usuario 
 * dado y devuelve un valor booleano.
 * 
 * boolean existsByEmail(String email): verifica si existe un usuario con el correo electrónico dado y 
 * devuelve un valor booleano.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinoferre.portfolio.Security.Entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNombreUsuario(String nombreUsuario);

	boolean existsByNombreUsuario(String nombreUsuario);

	boolean existsByEmail(String email);
}