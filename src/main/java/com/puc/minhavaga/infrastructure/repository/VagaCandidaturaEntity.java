package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "vagascandidaturas")
public class VagaCandidaturaEntity implements Serializable {
	
	private static final long serialVersionUID = 4750503963436112618L;
	
	@EmbeddedId
    private VagaCandidaturaEntityKey pk;
	
	@ManyToOne
    @MapsId("CandidatoId")
    @JoinColumn(name = "CandidatoId")
    private CandidatoEntity candidato;

    @ManyToOne
    @MapsId("VagaId")
    @JoinColumn(name = "VagaId")
    private VagaEntity vaga;
	
    @Column(name = "Status")
	private String status;
    
    @Column(name = "Feedback")
    private String feedback;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

	public VagaEntity getVaga() {
		return vaga;
	}

	public void setVaga(VagaEntity vaga) {
		this.vaga = vaga;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public VagaCandidaturaEntityKey getPk() {
		return pk;
	}

	public void setPk(VagaCandidaturaEntityKey pk) {
		this.pk = pk;
	}

	@Embeddable
	public static class VagaCandidaturaEntityKey implements Serializable {
		
		private static final long serialVersionUID = 6242969167703449936L;
		
		@Column(name = "CandidatoId")
		private Long candidatoId;
		
		@Column(name = "VagaId")
		private Long vagaId;

		public VagaCandidaturaEntityKey() {

		}

		public VagaCandidaturaEntityKey(Long candidatoId, Long vagaId) {
			super();
			this.candidatoId = candidatoId;
			this.vagaId = vagaId;
		}		
		
		public Long getCandidatoId() {
			return candidatoId;
		}

		public void setCandidatoId(Long candidatoId) {
			this.candidatoId = candidatoId;
		}

		public Long getVagaId() {
			return vagaId;
		}

		public void setVagaId(Long vagaId) {
			this.vagaId = vagaId;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(candidatoId, vagaId);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			VagaCandidaturaEntityKey other = (VagaCandidaturaEntityKey) obj;
			return Objects.equals(candidatoId, other.candidatoId) && Objects.equals(vagaId, other.vagaId);
		}
	} 
	
}
