package com.dws.customerservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dws.customerservice.model.Usuario;
import com.dws.customerservice.repository.UsuarioRepository;


@Service
public class UsuarioServiceImp implements UserDetailsService, UsuarioService{

	@Autowired
	private UsuarioRepository repouser;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Override 
	public ResponseEntity<Object> crearUsuario(Usuario usuario){
		Usuario usuario_existe = repouser.findByEmail(usuario.getEmail());
		HashMap<String, Object> response = new HashMap<>(); 
		
		if(usuario_existe != null) {
			response.put("mensaje", "Error al crear usuario. El usuario '" +  usuario_existe.getEmail() + "' ya se encuentra registrado");
			return new ResponseEntity<Object>(response, HttpStatus.PRECONDITION_FAILED);
		}
		
		// Se cifra la contraseña del usuario antes de persistirla en la DB
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		repouser.save(usuario);
		
		response.put("mensaje", "Usuario Creado Correctamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
		
	}
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repouser.findByEmail(email);
		// Si existe el usuario
		if(usuario != null) {
			List<GrantedAuthority> authorities = getUserAuthority(usuario.getTipo_usuario().getNombre_tipo_usuario());
			return buildUserForAuthentication(usuario, authorities);
		}else {
			throw new UsernameNotFoundException("Nombre de usuariuo no encontrado");
		}
	}

	

	private List<GrantedAuthority> getUserAuthority(String nombre_tipo_usuario) {
		Set<GrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(nombre_tipo_usuario));
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		
		return grantedAuthorities;
				
	}


	private UserDetails buildUserForAuthentication(Usuario usuario, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), authorities);
	}
}
