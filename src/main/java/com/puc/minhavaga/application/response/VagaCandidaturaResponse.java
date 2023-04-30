package com.puc.minhavaga.application.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.puc.minhavaga.domain.VagaCandidaturaStatus;

public class VagaCandidaturaResponse {
	
	private Long vagaId;
	
	private Long candidatoId;
	
	private VagaCandidaturaStatus status;
	
	private String feedback;
	
	@JsonCreator
	public VagaCandidaturaResponse(Long vagaId, Long candidatoId, VagaCandidaturaStatus status) {
		super();
		this.vagaId = vagaId;
		this.candidatoId = candidatoId;
		this.status = status;
	}
	
	@JsonCreator
	public VagaCandidaturaResponse(Long vagaId, Long candidatoId, VagaCandidaturaStatus status, String feedback) {
		super();
		this.vagaId = vagaId;
		this.candidatoId = candidatoId;
		this.status = status;
		this.feedback = feedback;
	}
	
	public Long getVagaId() {
		return vagaId;
	}

	public Long getCandidatoId() {
		return candidatoId;
	}

	public VagaCandidaturaStatus getStatus() {
		return status;
	}

	public String getFeedback() {
		return feedback;
	}

}
