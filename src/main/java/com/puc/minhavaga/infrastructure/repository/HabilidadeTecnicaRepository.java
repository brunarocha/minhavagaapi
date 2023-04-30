package com.puc.minhavaga.infrastructure.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HabilidadeTecnicaRepository extends JpaRepository<HabilidadeTecnicaEntity, Long> {

	@Transactional
	@Modifying
	@Query("delete from HabilidadeTecnicaEntity hte where hte.candidato.candidatoId = :candidatoId")
	void deleteByCandidatoCandidatoId(Long candidatoId);
	
}