package com.puc.minhavaga.domain.service;

import com.puc.minhavaga.domain.Recrutador;

public interface RecrutadorPersistence {
	
	Recrutador create(Recrutador recrutador) throws Exception;
	
	Recrutador findByUsuarioId(Long id) throws Exception;
	
	Recrutador findByRecrutadorId(Long id) throws Exception;
	
	void deleteByUsuarioId(Long id) throws Exception;

}
