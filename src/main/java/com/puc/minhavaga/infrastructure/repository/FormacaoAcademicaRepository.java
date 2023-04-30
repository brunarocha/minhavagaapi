package com.puc.minhavaga.infrastructure.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FormacaoAcademicaRepository extends JpaRepository<FormacaoAcademicaEntity, Long> {
	
	@Transactional
	@Modifying
	@Query("delete from FormacaoAcademicaEntity fae where fae.candidato.candidatoId = :candidatoId")
	void deleteByCandidatoCandidatoId(Long candidatoId);

}
