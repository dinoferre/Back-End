/**
 * El código presentado es una interfaz de repositorio de Spring Data JPA. La anotación @Repository indica que 
 * la interfaz es un componente de repositorio que permite realizar operaciones CRUD (crear, leer, actualizar y 
 * eliminar) en una base de datos relacionales a través de consultas JPA.
 * 
 * La interfaz extiende la interfaz JpaRepository, que proporciona varios métodos predefinidos para interactuar 
 * con la base de datos. En este caso, se utiliza el método findByRolNombre, que recibe un objeto RolNombre y 
 * devuelve un objeto Optional de Rol. Este método busca un objeto Rol en la base de datos que tenga el nombre 
 * de rol especificado.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinoferre.portfolio.Security.Entity.Rol;
import com.dinoferre.portfolio.Security.Enums.RolNombre;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}