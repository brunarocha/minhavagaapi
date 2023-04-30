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
@Table(name = "vagasbeneficios")
public class VagaBeneficioEntity implements Serializable {
	
	private static final long serialVersionUID = 4639568500520657221L;

	@Id
	@Column(name = "VagaBeneficioId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaBeneficioId;
	
	@ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "VagaId", referencedColumnName = "VagaId")
    private VagaEntity vaga;
	
	@Column(name = "Beneficio")
	private String beneficio;
	
	public VagaBeneficioEntity() {
		
	}
	
	public VagaBeneficioEntity(VagaEntity vaga, String beneficio) {
		super();
		this.vaga = vaga;
		this.beneficio = beneficio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getVagaBeneficioId() {
		return vagaBeneficioId;
	}

	public void setVagaBeneficioId(Long vagaBeneficioId) {
		this.vagaBeneficioId = vagaBeneficioId;
	}

	public VagaEntity getVaga() {
		return vaga;
	}

	public void setVaga(VagaEntity vaga) {
		this.vaga = vaga;
	}

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	
}
