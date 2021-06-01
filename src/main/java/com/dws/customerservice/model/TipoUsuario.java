package com.dws.customerservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="nombre")
	private String nombre_tipo_usuario;
	
	@Column(name="descripcion")
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_tipo_usuario() {
		return nombre_tipo_usuario;
	}

	public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
		this.nombre_tipo_usuario = nombre_tipo_usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
