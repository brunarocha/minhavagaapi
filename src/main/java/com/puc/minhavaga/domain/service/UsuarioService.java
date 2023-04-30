package com.puc.minhavaga.domain.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.puc.minhavaga.domain.Candidato;
import com.puc.minhavaga.domain.Recrutador;
import com.puc.minhavaga.domain.Usuario;

public interface UsuarioService {
	
	Authentication login(UsernamePasswordAuthenticationToken usuario) throws Exception;
		
	Usuario create(Usuario usuario) throws Exception;
	
	Usuario update(Long id, Usuario usuario) throws Exception;
	
	void delete(Long id) throws Exception;
	
	Candidato create(Candidato candidato) throws Exception;
	
	Recrutador create(Recrutador recrutador) throws Exception;
	
	Candidato update(Long id, Candidato candidato) throws Exception;
	
}