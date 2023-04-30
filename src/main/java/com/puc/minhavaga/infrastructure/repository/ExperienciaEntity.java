package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "experiencias")
public class ExperienciaEntity implements Serializable {
	
	private static final long serialVersionUID = 307895810692781803L;

	@Id
	@Column(name = "ExperienciaId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long experienciaId;
	
	@ManyToOne(cascade = CascadeType.DETACH)	
    @JoinColumn(name = "CandidatoId", referencedColumnName = "CandidatoId")
    private CandidatoEntity candidato;
	
	@Column(name = "Empresa")
	private String empresa;
	
	@Column(name = "Cargo")
	private String cargo;
	
	@Column(name = "Descricao")
	private String descricao;
	
	@Column(name = "DataInicio")
	private Date dataInicio;
	
	@Column(name = "DataFim")
	private Date dataFim;
	
	public ExperienciaEntity() {
		
	}
	
	public ExperienciaEntity(CandidatoEntity candidato, String empresa, String cargo, String descricao, Date dataInicio, Date dataFim) {
		this.candidato = candidato;
		this.empresa = empresa;
		this.cargo = cargo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getExperienciaId() {
		return experienciaId;
	}

	public void setExperienciaId(Long experienciaId) {
		this.experienciaId = experienciaId;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
}
