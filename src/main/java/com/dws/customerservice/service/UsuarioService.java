package com.dws.customerservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.dws.customerservice.model.Usuario;

public interface UsuarioService {
	public abstract UserDetails loadUserByUsername(String email);
	public abstract ResponseEntity<Object> crearUsuario(Usuario usuario);
}
