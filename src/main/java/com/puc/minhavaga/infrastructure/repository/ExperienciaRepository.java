package com.puc.minhavaga.infrastructure.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ExperienciaRepository extends JpaRepository<ExperienciaEntity, Long> {
	
	@Transactional
	@Modifying
	@Query("delete from ExperienciaEntity ee where ee.candidato.candidatoId = :candidatoId")
	void deleteByCandidatoCandidatoId(Long candidatoId);

}
