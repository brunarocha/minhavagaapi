package com.puc.minhavaga.domain;

import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FormacaoAcademica {

	private Long formacaoAcademicaId;
	
	private String instituicao;
	
	private String curso;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataFim;	

	public FormacaoAcademica(Long formacaoAcademicaId, String instituicao, String curso, LocalDate dataInicio, LocalDate dataFim) {
		super();
		this.formacaoAcademicaId = formacaoAcademicaId;
		this.instituicao = instituicao;
		this.curso = curso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Long getFormacaoAcademicaId() {
		return formacaoAcademicaId;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public String getCurso() {
		return curso;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}
	
}