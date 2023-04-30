package com.puc.minhavaga.domain;

import java.math.BigDecimal;
import java.util.List;

import com.puc.minhavaga.infrastructure.repository.VagaCandidaturaEntity;

public class Candidato extends Usuario {
	
	private static final long serialVersionUID = 4849339195981216704L;

	private Long candidatoId;
		
	private String arquivoCurriculo;
	
	private String sobre;
	
	private String celular;
		
	private BigDecimal faixaSalarialMin;
	
	private BigDecimal faixaSalarialMax;
		
	private List<String> habilidadesTecnicas;
	
	private List<FormacaoAcademica> formacoesAcademicas;
	
	private List<Experiencia> experiencias;
	
	private List<VagaCandidaturaEntity> candidaturas;
	
	public Candidato(Long candidatoId) {
		this.candidatoId = candidatoId;
	}
			
	public Candidato(Long usuarioId, UsuarioProfile profile, Long candidatoId, String arquivoCurriculo, String sobre, String celular, BigDecimal faixaSalarialMin,
			BigDecimal faixaSalarialMax, List<String> habilidadesTecnicas, List<FormacaoAcademica> formacoesAcademicas, List<Experiencia> experiencias) {
		super(usuarioId, null, null, null, profile);
		this.candidatoId = candidatoId;
		this.arquivoCurriculo = arquivoCurriculo;
		this.sobre = sobre;
		this.celular = celular;
		this.faixaSalarialMin = faixaSalarialMin;
		this.faixaSalarialMax = faixaSalarialMax;
		this.habilidadesTecnicas = habilidadesTecnicas;
		this.formacoesAcademicas = formacoesAcademicas;
		this.experiencias = experiencias;
	}
	
	public Long getCandidatoId() {
		return candidatoId;
	}

	public String getArquivoCurriculo() {
		return arquivoCurriculo;
	}

	public String getSobre() {
		return sobre;
	}

	public String getCelular() {
		return celular;
	}

	public BigDecimal getFaixaSalarialMin() {
		return faixaSalarialMin;
	}

	public BigDecimal getFaixaSalarialMax() {
		return faixaSalarialMax;
	}
	
	public List<String> getHabilidadesTecnicas() {
		return habilidadesTecnicas;
	}

	public List<FormacaoAcademica> getFormacoesAcademicas() {
		return formacoesAcademicas;
	}

	public List<Experiencia> getExperiencias() {
		return experiencias;
	}

}