/**
 * El código define un componente llamado JwtEntryPoint que implementa la interfaz 
 * AuthenticationEntryPoint. Esta clase se encarga de manejar la excepción de autenticación que se lanza 
 * cuando se intenta acceder a un recurso no autorizado.
 * 
 * El método "commence" se encarga de manejar esta excepción y enviar una respuesta de error HTTP 401 
 * (Unauthorized) al cliente. También registra un mensaje de error en el archivo de registro de la 
 * aplicación indicando que ha fallado el método commence.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Fallo el metodo commence");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}

}