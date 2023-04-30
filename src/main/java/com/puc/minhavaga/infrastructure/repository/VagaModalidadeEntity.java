package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vagasmodalidades")
public class VagaModalidadeEntity implements Serializable {
	
	private static final long serialVersionUID = 2987741152039944241L;

	@Id
	@Column(name = "VagaModalidadeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaModalidadeId;
	
	@Column(name = "Modalidade")
	private String modalidade;
	
	public VagaModalidadeEntity() {
		super();
	}
	
	public VagaModalidadeEntity(Long vagaModalidadeId) {
		super();
		this.vagaModalidadeId = vagaModalidadeId;
	}
	
	public VagaModalidadeEntity(Long vagaModalidadeId, String modalidade) {
		super();
		this.vagaModalidadeId = vagaModalidadeId;
		this.modalidade = modalidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getVagaModalidadeId() {
		return vagaModalidadeId;
	}

	public void setVagaModalidadeId(Long vagaModalidadeId) {
		this.vagaModalidadeId = vagaModalidadeId;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	
}
