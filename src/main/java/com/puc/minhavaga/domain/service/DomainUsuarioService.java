package com.puc.minhavaga.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.puc.minhavaga.domain.Candidato;
import com.puc.minhavaga.domain.Recrutador;
import com.puc.minhavaga.domain.Usuario;
import com.puc.minhavaga.infrastructure.exception.BadRequestException;
import com.puc.minhavaga.infrastructure.exception.NotFoundException;

@Service
public class DomainUsuarioService implements UsuarioService {
	
	@Autowired
	private UsuarioPersistence usuarioPersistence;
	
	@Autowired
	private CandidatoPersistence candidatoPersistence;
	
	@Autowired
	private RecrutadorPersistence recrutadorPersistence;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Authentication login(UsernamePasswordAuthenticationToken usuario) throws Exception {
		return authenticationManager.authenticate(usuario);
	}
	
	@Override
	public Usuario create(Usuario usuario) throws Exception {
		Usuario existing = usuarioPersistence.findByEmail(usuario.getEmail());
		
		if (existing != null) {
			throw new BadRequestException("Email", "Já existe um usuário cadastrado com o email informado!");
		}
		
		usuario.setEncodedSenha(encoder.encode(usuario.getSenha()));
		
		return usuarioPersistence.create(usuario);
	}
	
	@Override
	public Usuario update(Long id, Usuario usuario) throws Exception {
		Usuario found = usuarioPersistence.findUsuarioById(id);
		
		if (found == null) {
			throw new NotFoundException();
		}
		
		if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
			usuario.setEncodedSenha(encoder.encode(usuario.getSenha()));
		}
		
		return usuarioPersistence.update(id, usuario);
	}
	
	@Override
	public void delete(Long id) throws Exception {
		Usuario found = usuarioPersistence.findUsuarioById(id);
		
		if (found == null) {
			throw new NotFoundException();
		}
		
		if (found.isCandidato()) {
			candidatoPersistence.deleteByUsuarioId(found.getUsuarioId());
		} else {
			recrutadorPersistence.deleteByUsuarioId(found.getUsuarioId());
		}
		
		usuarioPersistence.delete(id);	
	}
	
	@Override
	public Candidato create(Candidato candidato) throws Exception {
		Candidato found = candidatoPersistence.findByUsuarioId(candidato.getUsuarioId());
		
		if (found != null) {
			throw new BadRequestException("UsuarioId", "Já existe um perfil cadastrado com o Id informado!");
		}		
		
		return candidatoPersistence.create(candidato);
	}	

	@Override
	public Candidato update(Long id, Candidato candidato) throws Exception {
		Candidato found = candidatoPersistence.findByCandidatoId(id);
		
		if (found == null) {
			throw new NotFoundException();
		}
		
		return candidatoPersistence.update(id, candidato);
	}
	
	@Override
	public Recrutador create(Recrutador recrutador) throws Exception {
		Recrutador found = recrutadorPersistence.findByUsuarioId(recrutador.getUsuarioId());
		
		if (found != null) {
			throw new BadRequestException("UsuarioId", "Já existe um perfil cadastrado com o Id informado!");
		}	
				
		return recrutadorPersistence.create(recrutador);
	}
	

}