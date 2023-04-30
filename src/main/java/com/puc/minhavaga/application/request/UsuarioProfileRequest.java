package com.puc.minhavaga.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.puc.minhavaga.domain.Candidato;
import com.puc.minhavaga.domain.Recrutador;
import com.puc.minhavaga.domain.UsuarioProfile;

public class UsuarioProfileRequest {
	
	private UsuarioProfile profile;
	
	private Candidato candidato;
	
	private Recrutador recrutador;

	@JsonCreator
	public UsuarioProfileRequest(final UsuarioProfile profile, final Candidato candidato, final Recrutador recrutador) {
		this.profile = profile;
		this.candidato = candidato;
		this.recrutador = recrutador;
	}
	
	public boolean isCandidato() {
		return this.profile.equals(UsuarioProfile.CANDIDATO);
	}
	
	public boolean isRecrutador() {
		return this.profile.equals(UsuarioProfile.RECRUTADOR);
	}
	
	public boolean isEmptyData() {
		return this.candidato == null && this.recrutador == null;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public Recrutador getRecrutador() {
		return recrutador;
	}
	
	public UsuarioProfile getProfile() {
		return profile;
	}

}