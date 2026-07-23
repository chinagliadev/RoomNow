package com.chinaglia.salaaluguelapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.chinaglia.salaaluguelapi.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	UserDetails findByEmail(String email);
	
	boolean existsByCpf(String cpf);
}
