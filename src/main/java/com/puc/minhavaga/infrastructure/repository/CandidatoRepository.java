package com.puc.minhavaga.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puc.minhavaga.infrastructure.repository.CandidatoEntity;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoEntity, Long> {
	
	CandidatoEntity findByUsuarioUsuarioId(Long usuarioId);
	
	CandidatoEntity findByCandidatoId(Long candidatoId);
}
