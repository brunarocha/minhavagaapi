package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "formacoesacademicas")
public class FormacaoAcademicaEntity implements Serializable {

	private static final long serialVersionUID = 3395408532840355888L;

	@Id
	@Column(name = "FormacaoAcademicaId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long formacaoAcademicaId;
	
	@ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "CandidatoId", referencedColumnName = "CandidatoId")
    private CandidatoEntity candidato;
	
	@Column(name = "Instituicao")
	private String instituicao;
	
	@Column(name = "Curso")
	private String curso;
	
	@Column(name = "DataInicio")
	private LocalDate dataInicio;
	
	@Column(name = "DataFim")
	private LocalDate dataFim;
	
	public FormacaoAcademicaEntity() {
		
	}
	
	public FormacaoAcademicaEntity(CandidatoEntity candidato, String instituicao, String curso, LocalDate dataInicio, LocalDate dataFim) {
		this.candidato = candidato;
		this.instituicao = instituicao;
		this.curso = curso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getFormacaoAcademicaId() {
		return formacaoAcademicaId;
	}

	public void setFormacaoAcademicaId(Long formacaoAcademicaId) {
		this.formacaoAcademicaId = formacaoAcademicaId;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
}
