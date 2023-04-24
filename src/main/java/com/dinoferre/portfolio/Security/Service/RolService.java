/**
 * El código presentado es una clase de servicio denominada RolService anotada con @Service y @Transactional. 
 * La clase es utilizada para realizar operaciones relacionadas con la entidad Rol en la base de datos.
 * 
 * La clase tiene dos atributos, ambos anotados con @Autowired. Uno es una instancia de IRolRepository, 
 * una interfaz que extiende de JpaRepository y define métodos para realizar operaciones con la base de datos. 
 * El otro atributo es UsuarioService, otra clase de servicio.
 * 
 * La clase tiene dos métodos. El primer método, getByRolNombre, toma un objeto RolNombre como argumento y 
 * utiliza el método findByRolNombre de la interfaz IRolRepository para buscar un objeto Rol en la base de datos. El segundo método, save, toma un objeto Rol como argumento y utiliza el método save de la interfaz IRolRepository para guardar el objeto en la base de datos.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Security.Entity.Rol;
import com.dinoferre.portfolio.Security.Enums.RolNombre;
import com.dinoferre.portfolio.Security.Repository.IRolRepository;

import javax.transaction.Transactional;

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