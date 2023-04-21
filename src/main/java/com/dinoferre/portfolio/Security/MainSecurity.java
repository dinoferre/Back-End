/**
 * Este código es una clase de configuración de seguridad en una aplicación web basada en Spring. 
 * Se habilita la seguridad web y la seguridad de métodos. Se crea un filtro personalizado para validar 
 * tokens JWT y un objeto PasswordEncoder para codificar contraseñas. También se crea un objeto 
 * AuthenticationManager para autenticar a los usuarios y se configura el SecurityFilterChain para 
 * proteger la aplicación. Se deshabilita CSRF, se configura la creación de sesiones sin estado 
 * y se define la política de autorización. En resumen, esta clase asegura la aplicación web Spring, 
 * definiendo cómo se autentican y autorizan los usuarios y cómo se protegen los recursos.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dinoferre.portfolio.Security.Jwt.JwtEntryPoint;
import com.dinoferre.portfolio.Security.Jwt.JwtTokenFilter;
import com.dinoferre.portfolio.Security.Service.ImpUserDetails;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class MainSecurity {
	@Autowired
	ImpUserDetails userDetailsServiceImpl;

	@Autowired
	JwtEntryPoint jwtEntryPoint;

	@Bean
	public JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeHttpRequests().requestMatchers("**").permitAll().anyRequest().authenticated();

		http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}