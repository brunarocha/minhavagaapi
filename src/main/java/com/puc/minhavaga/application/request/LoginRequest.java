package com.puc.minhavaga.application.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;

public class LoginRequest {
	
	@NotEmpty(message = "Email é obrigatório")
	@Email
	protected String email;
	
	@NotEmpty(message = "Senha é obrigatória")
	protected String senha;
	
	@JsonCreator
	public LoginRequest(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

}