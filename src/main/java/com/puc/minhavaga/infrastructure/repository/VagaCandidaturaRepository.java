package com.puc.minhavaga.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puc.minhavaga.infrastructure.repository.VagaCandidaturaEntity;

@Repository
public interface VagaCandidaturaRepository extends JpaRepository<
		VagaCandidaturaEntity, VagaCandidaturaEntity.VagaCandidaturaEntityKey> {
	
}
