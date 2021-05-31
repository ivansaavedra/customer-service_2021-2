package com.dws.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dws.customerservice.model.Usuario;
import com.dws.customerservice.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioCtrl {
	
	@Autowired
	UsuarioService usurario_srv;
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario) {
		return usurario_srv.crearUsuario(usuario);
	}
}
