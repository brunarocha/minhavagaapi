package com.puc.minhavaga.application.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.puc.minhavaga.domain.Recrutador;
import com.puc.minhavaga.domain.Vaga;
import com.puc.minhavaga.domain.VagaRequisito;

public class VagaRequest {
	
	@NotNull(message = "Id do recrutador é obrigatório")
	private Recrutador recrutador;
	
	@NotEmpty(message = "Título do cargo é obrigatório")
	private String cargo;
	
	@NotEmpty(message = "Descrição da vaga é obrigatória")
	private String descricao;
	
	private String empresa;
	
	private String local;
	
	private BigDecimal faixaSalarialMin;
	
	private BigDecimal faixaSalarialMax;
	
	private int numeroVagas;
	
	@NotNull(message = "Data de iníco para publicação da vaga é obrigatória")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataFim;
	
	@NotNull(message = "Modalidade da vaga é obrigatória")
	private Long modalidadeId;
	
	@NotNull(message = "Regime da vaga é obrigatória")
	private Long regimeId;
	
	private List<String> beneficios;
	
	private List<VagaRequisito> requisitos;
	
	public VagaRequest(Long vagaId, Recrutador recrutador, String cargo, String descricao, String empresa, String local,
			BigDecimal faixaSalarialMin, BigDecimal faixaSalarialMax, int numeroVagas, LocalDate dataInicio, 
			LocalDate dataFim, Long modalidadeId, Long regimeId, List<String> beneficios, List<VagaRequisito> requisitos) {
		this.recrutador = recrutador;
		this.cargo = cargo;
		this.descricao = descricao;
		this.empresa = empresa;
		this.local = local;
		this.faixaSalarialMin = faixaSalarialMin;
		this.faixaSalarialMax = faixaSalarialMax;
		this.numeroVagas = numeroVagas;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.modalidadeId = modalidadeId;
		this.regimeId = regimeId;
		this.beneficios = beneficios;
		this.requisitos = requisitos;
	}
	
	public Vaga parse() {
		return new Vaga(null, this.getRecrutador(), this.getCargo(), this.getDescricao(), this.getEmpresa(), this.getLocal(),
				this.getFaixaSalarialMin(), this.getFaixaSalarialMax(), this.getNumeroVagas(), this.getDataInicio(), this.getDataFim(),
				this.getModalidadeId(), this.getRegimeId(), this.getBeneficios(), this.getRequisitos(), null);
	}

	public Recrutador getRecrutador() {
		return recrutador;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getLocal() {
		return local;
	}

	public BigDecimal getFaixaSalarialMin() {
		return faixaSalarialMin;
	}

	public BigDecimal getFaixaSalarialMax() {
		return faixaSalarialMax;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}	

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public Long getModalidadeId() {
		return modalidadeId;
	}

	public Long getRegimeId() {
		return regimeId;
	}
	
	public List<String> getBeneficios() {
		return beneficios;
	}

	public List<VagaRequisito> getRequisitos() {
		return requisitos;
	}

}