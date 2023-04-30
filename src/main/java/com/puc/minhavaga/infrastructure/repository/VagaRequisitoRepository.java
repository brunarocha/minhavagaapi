package com.puc.minhavaga.infrastructure.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRequisitoRepository extends JpaRepository<VagaRequisitoEntity, Long> {

	@Transactional
	@Modifying
	@Query("delete from VagaRequisitoEntity vre where vre.vaga.vagaId = :vagaId")
	void deleteByVagaVagaId(Long vagaId);
}
