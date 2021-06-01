package com.dws.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dws.customerservice.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findById(int id);
	Usuario findByEmail(String email);

}
