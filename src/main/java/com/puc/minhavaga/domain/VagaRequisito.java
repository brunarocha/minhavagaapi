package com.puc.minhavaga.domain;

public class VagaRequisito {
	
	private String requisito;
	
	private Boolean requisitoObrigatorio;
	
	public VagaRequisito(String requisito, Boolean requisitoObrigatorio) {
		super();
		this.requisito = requisito;
		this.requisitoObrigatorio = requisitoObrigatorio == null ? false : requisitoObrigatorio;
	}

	public String getRequisito() {
		return requisito;
	}

	public Boolean getRequisitoObrigatorio() {
		return requisitoObrigatorio;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public void setRequisitoObrigatorio(Boolean requisitoObrigatorio) {
		this.requisitoObrigatorio = requisitoObrigatorio;
	}

}