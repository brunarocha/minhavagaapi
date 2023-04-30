package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "habilidadestecnicas")
public class HabilidadeTecnicaEntity implements Serializable {

	private static final long serialVersionUID = 2948987423488777194L;

	@Id
	@Column(name = "HabilidadeTecnicaId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long habilidadeTecnicaId;
	
	@ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "CandidatoId", referencedColumnName = "CandidatoId")
    private CandidatoEntity candidato;
	
	@Column(name = "HabilidadeTecnica")
	private String habilidadeTecnica;
	
	public HabilidadeTecnicaEntity() {
		
	}
	
	public HabilidadeTecnicaEntity(CandidatoEntity candidato, String habilidadeTecnica) {
		this.candidato = candidato;
		this.habilidadeTecnica = habilidadeTecnica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Long getHabilidadeTecnicaId() {
		return habilidadeTecnicaId;
	}

	public void setHabilidadeTecnicaId(Long habilidadeTecnicaId) {
		this.habilidadeTecnicaId = habilidadeTecnicaId;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

	public String getHabilidadeTecnica() {
		return habilidadeTecnica;
	}

	public void setHabilidadeTecnica(String habilidadeTecnica) {
		this.habilidadeTecnica = habilidadeTecnica;
	}
	
}
