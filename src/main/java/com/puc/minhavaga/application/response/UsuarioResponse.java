package com.puc.minhavaga.application.response;

import com.puc.minhavaga.domain.Usuario;
import com.puc.minhavaga.domain.UsuarioProfile;

public class UsuarioResponse {
	
	protected String nome;
	
	protected String email;
	
	protected UsuarioProfile profile;

	public UsuarioResponse(String nome, String email, UsuarioProfile profile) {
		super();
		this.nome = nome;
		this.email = email;
		this.profile = profile;
	}
	
	public UsuarioResponse(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.profile = usuario.getProfile();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public UsuarioProfile getProfile() {
		return profile;
	}

}
