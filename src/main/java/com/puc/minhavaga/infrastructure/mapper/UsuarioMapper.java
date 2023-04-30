package com.puc.minhavaga.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.puc.minhavaga.domain.Usuario;
import com.puc.minhavaga.domain.UsuarioProfile;
import com.puc.minhavaga.infrastructure.repository.ProfileEntity;
import com.puc.minhavaga.infrastructure.repository.UsuarioEntity;

@Component
public class UsuarioMapper {
	
	public UsuarioEntity usuarioToEntity(Usuario dto, UsuarioEntity entity) {
		if (entity == null) {
			entity = new UsuarioEntity();
		}
		
		entity.setUsuarioId(dto.getUsuarioId() != null ? dto.getUsuarioId() : entity.getUsuarioId());
		entity.setNome(dto.getNome() != null ? dto.getNome() : entity.getNome());
		entity.setEmail(dto.getEmail() != null ? dto.getEmail() : entity.getEmail());
		entity.setSenha(dto.getSenha() != null ? dto.getSenha() : entity.getSenha());
		entity.setProfile(dto.getProfile() != null ? profileToEntity(dto.getProfile()) : entity.getProfile());
		
		return entity;
	}
	
	public Usuario usuarioToDTO(UsuarioEntity entity) {
		if (entity == null) {
			return null;
		}
		
		return new Usuario(entity.getUsuarioId(), entity.getNome(), entity.getEmail(), entity.getSenha(), UsuarioProfile.valueOf(entity.getProfile().getProfile()));
	}
	
	public ProfileEntity profileToEntity(UsuarioProfile profile) {
		ProfileEntity entity = new ProfileEntity();
		entity.setProfile(profile.name());
		
		return entity;
	}

}
