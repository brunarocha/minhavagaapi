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
@Table(name = "vagasrequisitos")
public class VagaRequisitoEntity implements Serializable {
	
	private static final long serialVersionUID = 7441960010108229725L;

	@Id
	@Column(name = "VagaRequisitoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaRequisitoId;
	
	@ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "VagaId", referencedColumnName = "VagaId")
    private VagaEntity vaga;	
	
	@Column(name = "Requisito")
	private String requisito;
	
	@Column(name = "RequisitoObrigatorio")
	private Boolean requisitoObrigatorio;

	public VagaRequisitoEntity() {
		super();
	}
	
	public VagaRequisitoEntity(VagaEntity vaga, String requisito, Boolean requisitoObrigatorio) {
		super();
		this.vaga = vaga;
		this.requisito = requisito;
		this.requisitoObrigatorio = requisitoObrigatorio;
	}
	
	public VagaRequisitoEntity(Long vagaRequisitoId, VagaEntity vaga, String requisito, Boolean requisitoObrigatorio) {
		super();
		this.vagaRequisitoId = vagaRequisitoId;
		this.vaga = vaga;
		this.requisito = requisito;
		this.requisitoObrigatorio = requisitoObrigatorio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getVagaRequisitoId() {
		return vagaRequisitoId;
	}

	public void setVagaRequisitoId(Long vagaRequisitoId) {
		this.vagaRequisitoId = vagaRequisitoId;
	}

	public VagaEntity getVaga() {
		return vaga;
	}

	public void setVaga(VagaEntity vaga) {
		this.vaga = vaga;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public Boolean getRequisitoObrigatorio() {
		return requisitoObrigatorio;
	}

	public void setRequisitoObrigatorio(Boolean requisitoObrigatorio) {
		this.requisitoObrigatorio = requisitoObrigatorio;
	}
	
}
