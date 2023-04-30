package com.puc.minhavaga.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puc.minhavaga.infrastructure.repository.RecrutadorEntity;

@Repository
public interface RecrutadorRepository extends JpaRepository<RecrutadorEntity, Long> {
	
	RecrutadorEntity findByUsuarioUsuarioId(Long usuarioId);
	
	RecrutadorEntity findByRecrutadorId(Long recrutadorId);
	
}
