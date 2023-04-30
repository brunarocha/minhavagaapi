package com.puc.minhavaga.application.response;

import com.puc.minhavaga.domain.UsuarioProfile;

public class LoginResponse {
	
	private String token;
	private String type = "Bearer";
	private String email;
	private UsuarioProfile profile;
	
	public LoginResponse(String accessToken, String email, UsuarioProfile profile) {
		this.token = accessToken;
		this.email = email;
		this.profile = profile;
	}
	
	public String getAccessToken() {
		return token;
	}
	
	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}
	
	public String getTokenType() {
		return type;
	}
	
	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UsuarioProfile getProfile() {
		return this.profile;
	}
	
}
