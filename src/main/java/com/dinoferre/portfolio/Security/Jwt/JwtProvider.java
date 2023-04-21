/**
 * Implementación de autenticación y autorización basada en JWT (JSON Web Tokens) para una aplicación web Java. 
 * 
 * Usuario: es una clase que representa un usuario en el sistema, y contiene información como su nombre, 
 * nombre de usuario, correo electrónico, contraseña y roles asignados.
 * 
 * UsuarioPrincipal: es una clase que implementa la interfaz UserDetails de Spring Security, y representa el 
 * principal de seguridad que se utiliza en la autenticación. Contiene información sobre el usuario, como su 
 * nombre, nombre de usuario, correo electrónico, contraseña y roles asignados.
 * 
 * RolNombre: es una enumeración que contiene los nombres de los roles que se utilizan en el sistema, 
 * como ROLE_ADMIN y ROLE_USER.
 * 
 * JwtEntryPoint: es una clase que implementa la interfaz AuthenticationEntryPoint de Spring Security, y se 
 * utiliza para manejar los errores de autenticación. En este caso, simplemente devuelve un error 
 * 401 (no autorizado) si ocurre algún error de autenticación.
 * 
 * JwtProvider: es una clase que se utiliza para generar y validar los tokens JWT. Contiene un método para 
 * generar un token a partir de un objeto Authentication de Spring Security, un método para obtener el nombre 
 * de usuario a partir de un token, y un método para validar un token. La firma del token se realiza utilizando 
 * un secreto y el algoritmo HS512. Los valores del secreto y el tiempo de expiración del token se leen desde 
 * un archivo de propiedades utilizando la anotación @Value.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.dinoferre.portfolio.Security.Entity.UsuarioPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {

	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private int expiration;

	public String generateToken(Authentication authentication) {
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
		return Jwts.builder().setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public String getNombreusuarioFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Token mal formado");
		} catch (UnsupportedJwtException e) {
			logger.error("Token no soportado");
		} catch (ExpiredJwtException e) {
			logger.error("Token expirado");
		} catch (IllegalArgumentException e) {
			logger.error("Token vacio");
		} catch (SignatureException e) {
			logger.error("Firma no valida");
		}
		return false;
	}

}