package com.puc.minhavaga.domain;

public class VagaCandidatura {

	private Vaga vaga;
	
	private Candidato candidato;
	
	private VagaCandidaturaStatus status;
	
	private String feedback;
	
	public VagaCandidatura(Vaga vaga, Candidato candidato, VagaCandidaturaStatus status, String feedback) {
		super();
		this.vaga = vaga;
		this.candidato = candidato;
		this.status = status;
		this.feedback = feedback;
	}
	
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	public Vaga getVaga() {
		return vaga;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public VagaCandidaturaStatus getStatus() {
		return status;
	}
	
	public void setStatus(VagaCandidaturaStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}
	
	public void sent() {
		this.status = VagaCandidaturaStatus.SENT;
	}
}
