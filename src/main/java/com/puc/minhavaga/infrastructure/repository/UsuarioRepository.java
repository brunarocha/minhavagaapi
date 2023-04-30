package com.puc.minhavaga.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puc.minhavaga.infrastructure.repository.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
	UsuarioEntity findByEmail(String email);
	
}
