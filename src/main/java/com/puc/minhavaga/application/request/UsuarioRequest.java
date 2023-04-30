package com.puc.minhavaga.application.request;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.puc.minhavaga.domain.Usuario;
import com.puc.minhavaga.domain.UsuarioProfile;

public class UsuarioRequest {
	
	@NotEmpty(message = "Nome é obrigatório")
	protected String nome;
	
	@NotEmpty(message = "Email é obrigatório")
	@Email
	protected String email;
	
	@NotEmpty(message = "Senha é obrigatória")
	protected String senha;
	
	@NotNull(message = "Perfil do usuário é obrigatório")
	protected UsuarioProfile profile;
	
	public UsuarioRequest() {
		
	}
	
	@JsonCreator
	public UsuarioRequest(String nome, String email, String senha, UsuarioProfile profile) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.profile = profile;
	}
	
	public Usuario parse() {
		return new Usuario(null, this.getNome(), this.getEmail(), this.getSenha(), this.getProfile());
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public UsuarioProfile getProfile() {
		return profile;
	}
	
	public boolean isCandidato() {
		return this.profile.equals(UsuarioProfile.CANDIDATO);
	}
	
	public boolean isRecrutador() {
		return this.profile.equals(UsuarioProfile.RECRUTADOR);
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.getEmail());
    }	

}
