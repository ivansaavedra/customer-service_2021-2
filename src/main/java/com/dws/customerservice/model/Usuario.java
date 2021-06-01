package com.dws.customerservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(optional=true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_tipo_usuario", insertable=false, updatable=false)
	private TipoUsuario tipo_usuario;
	
	@Column(name="id_tipo_usuario")
	private String id_tipo_usuario;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoUsuario getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(TipoUsuario tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(String id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	
	
	
	
}
