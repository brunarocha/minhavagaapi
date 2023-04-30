package com.puc.minhavaga.domain.service;

import java.util.List;
import java.util.Map;

import com.puc.minhavaga.domain.Vaga;
import com.puc.minhavaga.domain.VagaCandidatura;

public interface VagaPersistence {

	List<Vaga> findAll(Map<String,String> params);
	
	Vaga create(Vaga vaga);
	
	Vaga update(Long id, Vaga vaga);
	
	Vaga findByVagaId(Long id);
	
	void delete(Long id) throws Exception;
	
	VagaCandidatura create(VagaCandidatura candidatura);
	
	VagaCandidatura update(Long id, VagaCandidatura candidatura);
	
}
