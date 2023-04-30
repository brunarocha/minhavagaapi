package com.puc.minhavaga.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Usuario implements UserDetails {

	private static final long serialVersionUID = 9081206593790507474L;

	private Long usuarioId;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private UsuarioProfile profile;
	
	public Usuario() {
		
	}
	
	public Usuario(Long usuarioId, String nome, String email, String senha, UsuarioProfile profile) {
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.profile = profile;
	}

	public Long getUsuarioId() {
		return usuarioId;
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
	
	public void setEncodedSenha(String senha) {
		this.senha = senha;
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
        return Objects.equals(usuarioId, usuario.usuarioId);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(this.profile.name()));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}