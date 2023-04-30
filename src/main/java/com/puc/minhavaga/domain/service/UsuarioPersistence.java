package com.puc.minhavaga.domain.service;

import com.puc.minhavaga.domain.Usuario;

public interface UsuarioPersistence {

	Usuario create(Usuario usuario) throws Exception;
	
	Usuario update(Long id, Usuario usuario) throws Exception;
	
	void delete(Long id) throws Exception;
	
	Usuario findByEmail(String email) throws Exception;
	
	Usuario findUsuarioById(Long usuarioById) throws Exception;
	
}