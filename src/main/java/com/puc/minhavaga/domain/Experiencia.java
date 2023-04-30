package com.puc.minhavaga.domain;

import java.util.Date;

public class Experiencia {
	
	private Long experienciaId;
	
	private String empresa;
	
	private String cargo;
	
	private String descricao;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	public Experiencia() {
		
	}

	public Experiencia(String empresa, String cargo, String descricao, Date dataInicio, Date dataFim) {
		this.empresa = empresa;
		this.cargo = cargo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Long getExperienciaId() {
		return experienciaId;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

}
