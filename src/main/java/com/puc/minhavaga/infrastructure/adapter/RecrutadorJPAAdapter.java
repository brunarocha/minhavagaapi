package com.puc.minhavaga.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puc.minhavaga.domain.Recrutador;
import com.puc.minhavaga.domain.service.RecrutadorPersistence;
import com.puc.minhavaga.infrastructure.mapper.RecrutadorMapper;
import com.puc.minhavaga.infrastructure.repository.RecrutadorEntity;
import com.puc.minhavaga.infrastructure.repository.RecrutadorRepository;

@Component
public class RecrutadorJPAAdapter implements RecrutadorPersistence {
	
	@Autowired
	private RecrutadorRepository recrutadorRepository;
	
	@Autowired
	private RecrutadorMapper mapper;
	
	@Override
	public Recrutador create(Recrutador recrutador) throws Exception {
		RecrutadorEntity created = recrutadorRepository.saveAndFlush(mapper.recrutadorToEntity(recrutador, null));
		
		return mapper.recrutadorToDTO(created);
	}
	
	@Override
	public Recrutador findByUsuarioId(Long usuarioId) throws Exception {
		RecrutadorEntity found = recrutadorRepository.findByUsuarioUsuarioId(usuarioId);
		
		return mapper.recrutadorToDTO(found);
	}

	@Override
	public Recrutador findByRecrutadorId(Long id) throws Exception {
		RecrutadorEntity found = recrutadorRepository.findByRecrutadorId(id);
		
		return mapper.recrutadorToDTO(found);
	}

	@Override
	public void deleteByUsuarioId(Long usuarioId) throws Exception {
		RecrutadorEntity found = recrutadorRepository.findByUsuarioUsuarioId(usuarioId);
		Long recrutadorId = found.getRecrutadorId();
		
		recrutadorRepository.deleteById(recrutadorId);		
	}

}