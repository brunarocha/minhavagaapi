package com.puc.minhavaga.domain;

public class HabilidadeTecnica {
	
	private Long habilidadeTecnicaId;
	
	private String habilidadeTecnica;
	
	public HabilidadeTecnica() {
		
	}

	public HabilidadeTecnica(Long habilidadeTecnicaId, String habilidadeTecnica) {
		super();
		this.habilidadeTecnicaId = habilidadeTecnicaId;
		this.habilidadeTecnica = habilidadeTecnica;
	}

	public Long getHabilidadeTecnicaId() {
		return habilidadeTecnicaId;
	}

	public String getHabilidadeTecnica() {
		return habilidadeTecnica;
	}
	
}