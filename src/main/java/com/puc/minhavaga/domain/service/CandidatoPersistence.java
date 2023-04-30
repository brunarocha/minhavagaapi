package com.puc.minhavaga.domain.service;

import com.puc.minhavaga.domain.Candidato;

public interface CandidatoPersistence {
	
	Candidato create(Candidato candidato) throws Exception;
	
	Candidato update(Long id , Candidato candidato) throws Exception;
	
	Candidato findByUsuarioId(Long id) throws Exception;
	
	Candidato findByCandidatoId(Long id) throws Exception;
	
	void deleteByUsuarioId(Long id) throws Exception;

}
