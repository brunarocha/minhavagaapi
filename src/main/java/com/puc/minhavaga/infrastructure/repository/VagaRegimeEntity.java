package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vagasregimes")
public class VagaRegimeEntity implements Serializable {
	
	private static final long serialVersionUID = 3515634302159652523L;

	@Id
	@Column(name = "VagaRegimeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaRegimeId;
	
	@Column(name = "Regime")
	private String regime;
	
	public VagaRegimeEntity() {
		super();
	}
	
	public VagaRegimeEntity(Long vagaRegimeId) {
		super();
		this.vagaRegimeId = vagaRegimeId;
	}
	
	public VagaRegimeEntity(Long vagaRegimeId, String regime) {
		super();
		this.vagaRegimeId = vagaRegimeId;
		this.regime = regime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getVagaRegimeId() {
		return vagaRegimeId;
	}

	public void setVagaRegimeId(Long vagaRegimeId) {
		this.vagaRegimeId = vagaRegimeId;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}
	
}
