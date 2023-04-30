package com.puc.minhavaga.domain;

public class Recrutador extends Usuario {

	private static final long serialVersionUID = 7975535908998562840L;
	
	private Long recrutadorId;
	
	public Recrutador(Long recrutadorId) {
		this.recrutadorId = recrutadorId;
	}
	
	public Recrutador(Long usuarioId, UsuarioProfile profile, Long recrutadorId) {
		super(usuarioId, null, null, null, profile);
		this.recrutadorId = recrutadorId;
	}

	public Long getRecrutadorId() {
		return recrutadorId;
	}	
	
}