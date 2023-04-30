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
@Table(name = "recrutadores")
public class RecrutadorEntity implements Serializable {

	private static final long serialVersionUID = 8981186738981875740L;
	
	@Id
	@Column(name = "RecrutadorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recrutadorId;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    private UsuarioEntity usuario;
	
	public RecrutadorEntity() {
		
	}
	
	public RecrutadorEntity(Long recrutadorId, UsuarioEntity usuario) {
		super();
		this.recrutadorId = recrutadorId;
		this.usuario = usuario;
	}
	
	public RecrutadorEntity(Long recrutadorId) {
		super();
		this.recrutadorId = recrutadorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getRecrutadorId() {
		return recrutadorId;
	}

	public void setRecrutadorId(Long recrutadorId) {
		this.recrutadorId = recrutadorId;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

}
