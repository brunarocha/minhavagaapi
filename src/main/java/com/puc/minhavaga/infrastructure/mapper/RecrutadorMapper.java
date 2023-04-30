package com.puc.minhavaga.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.puc.minhavaga.domain.Recrutador;
import com.puc.minhavaga.domain.UsuarioProfile;
import com.puc.minhavaga.infrastructure.repository.RecrutadorEntity;
import com.puc.minhavaga.infrastructure.repository.UsuarioEntity;

@Component
public class RecrutadorMapper {
	
	public RecrutadorEntity recrutadorToEntity(Recrutador dto, RecrutadorEntity entity) {
		if (entity == null) {
			entity = new RecrutadorEntity();
		}
		
		entity.setUsuario(dto.getUsuarioId() != null ? new UsuarioEntity(dto.getUsuarioId()) : entity.getUsuario());
		
		return entity;
	}
	
	public Recrutador recrutadorToDTO(RecrutadorEntity entity) {
		if (entity == null) {
			return null;
		}
		
		return new Recrutador(entity.getUsuario().getUsuarioId(), UsuarioProfile.RECRUTADOR, entity.getRecrutadorId());
	}

}