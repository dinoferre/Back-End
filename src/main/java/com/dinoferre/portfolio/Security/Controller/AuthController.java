/**
 * El código muestra un controlador Rest con dos endpoints, "/nuevo" y "/login", que reciben peticiones 
 * HTTP POST.
 * 
 * En el endpoint "/nuevo", el método "nuevo" crea un nuevo usuario a partir de los datos proporcionados 
 * en la petición y lo guarda en la base de datos. Antes de guardar el usuario, se comprueba si ya 
 * existe un usuario con el mismo nombre de usuario o email. Si los datos proporcionados son incorrectos, 
 * se devuelve un mensaje de error.
 * 
 * En el endpoint "/login", el método "login" valida las credenciales de usuario y devuelve un token JWT 
 * si son correctas. Si las credenciales no son válidas, se devuelve un mensaje de error.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinoferre.portfolio.Security.DTO.JwtDto;
import com.dinoferre.portfolio.Security.DTO.LoginUsuario;
import com.dinoferre.portfolio.Security.DTO.NuevoUsuario;
import com.dinoferre.portfolio.Security.Entity.Rol;
import com.dinoferre.portfolio.Security.Entity.Usuario;
import com.dinoferre.portfolio.Security.Enums.RolNombre;
import com.dinoferre.portfolio.Security.Jwt.JwtProvider;
import com.dinoferre.portfolio.Security.Service.RolService;
import com.dinoferre.portfolio.Security.Service.UsuarioService;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
		
		if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
		
		if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("Ese email de usuario ya existe"), HttpStatus.BAD_REQUEST);
		
		Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), 
				nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
		
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		
		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		
		usuario.setRoles(roles);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario Guardado"), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), 
				loginUsuario.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateToken(authentication);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}

}