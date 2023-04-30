package com.puc.minhavaga.domain.service;

import java.util.List;
import java.util.Map;

import com.puc.minhavaga.domain.Vaga;
import com.puc.minhavaga.domain.VagaCandidatura;

public interface VagaService {
	
	List<Vaga> all(Map<String,String> params);
	
	Vaga findById(Long id) throws Exception;
		
	Vaga create(Vaga vaga) throws Exception;
	
	Vaga update(Long id, Vaga vaga) throws Exception;
	
	void delete(Long id) throws Exception;
	
	VagaCandidatura create(VagaCandidatura candidatura) throws Exception;
	
	VagaCandidatura update(Long id, VagaCandidatura candidatura) throws Exception;
	
}
