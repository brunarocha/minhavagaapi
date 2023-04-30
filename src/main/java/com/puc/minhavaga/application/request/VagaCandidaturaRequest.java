package com.puc.minhavaga.application.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.puc.minhavaga.domain.Candidato;
import com.puc.minhavaga.domain.Vaga;
import com.puc.minhavaga.domain.VagaCandidatura;
import com.puc.minhavaga.domain.VagaCandidaturaStatus;

public class VagaCandidaturaRequest {
	
	@NotNull(message = "Id da Vaga é obrigatório")
	private Long vagaId;
	
	@NotNull(message = "Id do Candidato é obrigatório")
	private Long candidatoId;
	
	private VagaCandidaturaStatus status;
	
	private String feedback;
	
	@JsonCreator
	public VagaCandidaturaRequest(Long vagaId, Long candidatoId, VagaCandidaturaStatus status, String feedback) {
		super();
		this.vagaId = vagaId;
		this.candidatoId = candidatoId;
		this.status = status;
		this.feedback = feedback;
	}
	
	public VagaCandidatura parse() {
		return new VagaCandidatura(new Vaga(vagaId), new Candidato(candidatoId), status, this.getFeedback());
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