package com.puc.minhavaga.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vaga {
	
	private Long vagaId;
	
	private Recrutador recrutador;
	
	private String cargo;
	
	private String descricao;
	
	private String empresa;
	
	private String local;
	
	private BigDecimal faixaSalarialMin;
	
	private BigDecimal faixaSalarialMax;
	
	private int numeroVagas;
	
	private LocalDate dataInicio;
	
	private LocalDate dataFim;
	
	private Long modalidadeId;
	
	private Long regimeId;
	
	private VagaStatus status;
	
	private List<String> beneficios;
	
	private List<VagaRequisito> requisitos;
	
	private List<VagaCandidatura> candidaturas;
	
	public Vaga(Long vagaId) {
		this.vagaId = vagaId;
	}
	
	public Vaga(Long vagaId, Recrutador recrutador, String cargo, String descricao, String empresa, String local,
			BigDecimal faixaSalarialMin, BigDecimal faixaSalarialMax, int numeroVagas, LocalDate dataInicio, 
			LocalDate dataFim, Long modalidadeId, Long regimeId, List<String> beneficios, List<VagaRequisito> requisitos,
			List<VagaCandidatura> candidaturas) {
		this.vagaId = vagaId;
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
		this.candidaturas = candidaturas;
	}
	
	public void open() {
		this.status = VagaStatus.OPEN;
	}

	public Long getVagaId() {
		return vagaId;
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
	
	public VagaStatus getStatus() {
		if (dataFim == null) {
			return VagaStatus.OPEN;
		}
		
		return LocalDate.now().isBefore(dataFim) ? VagaStatus.OPEN : VagaStatus.CLOSED;
	}
	
	public List<String> getBeneficios() {
		return beneficios == null ? new ArrayList<String>() : beneficios;
	}

	public List<VagaRequisito> getRequisitos() {
		return requisitos;
	}
	
	public List<VagaCandidatura> getCandidaturas() {
		return candidaturas;
	}
	
}
