/**
 * La clase JwtDto tiene cuatro atributos: token (un token de autenticación JWT), 
 * bearer (un string con el valor "Bearer"), nombreUsuario (el nombre del usuario autenticado) 
 * y authorities (una colección de objetos GrantedAuthority que representan los permisos del usuario). 
 * La clase también tiene un constructor, getters y setters para los atributos.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Security.DTO;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDto {

	private String token;
	private String bearer = "Bearer";
	private String nombreUsuario;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtDto() {

	}

	public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.nombreUsuario = nombreUsuario;
		this.authorities = authorities;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}