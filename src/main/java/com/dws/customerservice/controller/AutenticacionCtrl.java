package com.dws.customerservice.controller;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dws.customerservice.config.JwtTokenProvider;
import com.dws.customerservice.dto.AutenticacionBody;
import com.dws.customerservice.model.Usuario;
import com.dws.customerservice.repository.UsuarioRepository;
import com.dws.customerservice.service.UsuarioServiceImp;


@RestController
@RequestMapping("/api/autenticacion")
public class AutenticacionCtrl {
	
	@Autowired
	AuthenticationManager authenticationmanager;
	
    @Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	UsuarioRepository users;
	
	@Autowired
	UsuarioServiceImp usuarios;
	
	@PostMapping("/login")
	public ResponseEntity<Map<Object,Object>> login(@RequestBody AutenticacionBody datos) {
		try {
			String email = datos.getEmail();
			Usuario usuario = this.users.findByEmail(email);
			
			
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(email, datos.getPassword()));
            String token = jwtTokenProvider.createToken(email, usuario.getTipo_usuario());
            
            Map<Object, Object> respuesta = new HashMap<>();            
            respuesta.put("username", usuario.getEmail());
            respuesta.put("token", token);
            return ok(respuesta);
				
		}catch(Exception e) {
			Map<Object, Object> respuesta = new HashMap<>();   
			respuesta.put("Mensaje", "Error en proceso de autenticacion");
			respuesta.put("Exception", e.getMessage());
			return new ResponseEntity<Map<Object, Object>>(respuesta, HttpStatus.I_AM_A_TEAPOT);
		}
		
		
	}

}
