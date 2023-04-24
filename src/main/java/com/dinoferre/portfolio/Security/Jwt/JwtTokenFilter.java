/**
 * El código muestra la implementación de un filtro de tokens JWT para autenticación en una aplicación web. 
 * El filtro se encarga de interceptar cada petición entrante y verificar si el token JWT está presente en el 
 * encabezado de autorización y es válido. Si el token es válido, se recupera el nombre de usuario del token y 
 * se carga la información del usuario en el contexto de seguridad de Spring utilizando el servicio 
 * UserDetailsService. El filtro se implementa extendiendo la clase OncePerRequestFilter de Spring y anotando 
 * la clase como @Component para que sea escaneada por el contenedor de Spring.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.Jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dinoferre.portfolio.Security.Service.ImpUserDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtTokenFilter extends OncePerRequestFilter {

	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	ImpUserDetails userDetailsServiceImp;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = getToken(request);
			if (token != null && jwtProvider.validateToken(token)) {
				String nombreUsuario = jwtProvider.getNombreusuarioFromToken(token);
				UserDetails userDetails = userDetailsServiceImp.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			logger.error("Fallo el metodo doFilterInternal");
		}

		filterChain.doFilter(request, response);

	}

	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer"))
			return header.replace("Bearer", "");
		return null;
	}

}