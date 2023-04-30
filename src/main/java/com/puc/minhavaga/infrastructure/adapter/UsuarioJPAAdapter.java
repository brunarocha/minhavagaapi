package com.puc.minhavaga.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puc.minhavaga.domain.Usuario;
import com.puc.minhavaga.domain.service.UsuarioPersistence;
import com.puc.minhavaga.infrastructure.mapper.UsuarioMapper;
import com.puc.minhavaga.infrastructure.repository.UsuarioEntity;
import com.puc.minhavaga.infrastructure.repository.UsuarioRepository;

@Component
public class UsuarioJPAAdapter implements UsuarioPersistence {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@Autowired
	private UsuarioMapper mapper;
	
	@Override
	public Usuario create(Usuario usuario) throws Exception {
		UsuarioEntity created = usuarioRepository.save(mapper.usuarioToEntity(usuario, null));
		
		return mapper.usuarioToDTO(created);
	}
	
	@Override
	public Usuario update(Long id, Usuario usuario) throws Exception {
		UsuarioEntity entity = this.findByUsuarioId(id);
		entity = usuarioRepository.save(mapper.usuarioToEntity(usuario, entity));
		
		return mapper.usuarioToDTO(entity);
	}
	
	@Override
	public void delete(Long id) throws Exception {
		usuarioRepository.deleteById(id);
	}
	
	@Override
	public Usuario findUsuarioById(Long usuarioId) throws Exception {
		UsuarioEntity found = this.findByUsuarioId(usuarioId);
		
		return mapper.usuarioToDTO(found);
	}
	
	@Override
	public Usuario findByEmail(String email) throws Exception {
		UsuarioEntity existing = usuarioRepository.findByEmail(email);
		
		return mapper.usuarioToDTO(existing);
	}
	
	private UsuarioEntity findByUsuarioId(Long usuarioId) throws Exception {
		return usuarioRepository.findById(usuarioId).orElse(null);
	}
	
}