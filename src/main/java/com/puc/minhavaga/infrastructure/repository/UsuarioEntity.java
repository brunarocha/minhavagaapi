package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 9010892541704191639L;
	
	@Id
	@Column(name = "UsuarioId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;
	
	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "Senha")
	private String senha;
		
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "Profile", referencedColumnName = "Profile")
    private ProfileEntity profile;
	
	public UsuarioEntity() {
		
	}
	
	public UsuarioEntity(Long id) {
		this.usuarioId = id;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}
	
}
