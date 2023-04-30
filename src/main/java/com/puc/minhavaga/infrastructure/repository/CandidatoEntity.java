package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidatos")
public class CandidatoEntity implements Serializable {

	private static final long serialVersionUID = 4776332463242300599L;
	
	@Id
	@Column(name = "CandidatoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidatoId;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    private UsuarioEntity usuario;
	
	@Column(name = "ArquivoCurriculo")
	private String arquivoCurriculo;
	
	@Column(name = "Sobre")
	private String sobre;
	
	@Column(name = "Celular")
	private String celular;
		
	@Column(name = "FaixaSalarialMin")
	private BigDecimal faixaSalarialMin;
	
	@Column(name = "FaixaSalarialMax")
	private BigDecimal faixaSalarialMax;
		
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
    private List<HabilidadeTecnicaEntity> habilidadesTecnicas;
	
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
	private List<FormacaoAcademicaEntity> formacoesAcademicas;
	
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
    private List<ExperienciaEntity> experiencias;
	
	@OneToMany(mappedBy = "candidato")
	private List<VagaCandidaturaEntity> candidaturas;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getCandidatoId() {
		return candidatoId;
	}

	public void setCandidatoId(Long candidatoId) {
		this.candidatoId = candidatoId;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public String getArquivoCurriculo() {
		return arquivoCurriculo;
	}

	public void setArquivoCurriculo(String arquivoCurriculo) {
		this.arquivoCurriculo = arquivoCurriculo;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public BigDecimal getFaixaSalarialMin() {
		return faixaSalarialMin;
	}

	public void setFaixaSalarialMin(BigDecimal faixaSalarialMin) {
		this.faixaSalarialMin = faixaSalarialMin;
	}

	public BigDecimal getFaixaSalarialMax() {
		return faixaSalarialMax;
	}

	public void setFaixaSalarialMax(BigDecimal faixaSalarialMax) {
		this.faixaSalarialMax = faixaSalarialMax;
	}

	public List<HabilidadeTecnicaEntity> getHabilidadesTecnicas() {
		return habilidadesTecnicas;
	}

	public void setHabilidadesTecnicas(List<HabilidadeTecnicaEntity> habilidadesTecnicas) {
		this.habilidadesTecnicas = habilidadesTecnicas;
	}

	public List<FormacaoAcademicaEntity> getFormacoesAcademicas() {
		return formacoesAcademicas;
	}

	public void setFormacoesAcademicas(List<FormacaoAcademicaEntity> formacoesAcademicas) {
		this.formacoesAcademicas = formacoesAcademicas;
	}

	public List<ExperienciaEntity> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(List<ExperienciaEntity> experiencias) {
		this.experiencias = experiencias;
	}

	public List<VagaCandidaturaEntity> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(List<VagaCandidaturaEntity> candidaturas) {
		this.candidaturas = candidaturas;
	}

}
