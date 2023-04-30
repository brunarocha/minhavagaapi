package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vagas")
public class VagaEntity implements Serializable {

	private static final long serialVersionUID = 8764540845232680430L;

	@Id
	@Column(name = "VagaId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaId;
	
	@ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "RecrutadorId", referencedColumnName = "RecrutadorId")
    private RecrutadorEntity recrutador;
	
	@Column(name = "Cargo")
	private String cargo;
	
	@Column(name = "Descricao")
	private String descricao;
	
	@Column(name = "Empresa")
	private String empresa;
	
	@Column(name = "Local")
	private String local;
	
	@Column(name = "FaixaSalarialMin")
	private BigDecimal faixaSalarialMin;
	
	@Column(name = "FaixaSalarialMax")
	private BigDecimal faixaSalarialMax;
	
	@Column(name = "DataInicio")
	private LocalDate dataInicio;
	
	@Column(name = "DataFim")
	private LocalDate dataFim;
	
	@Column(name = "NumeroVagas")
	private int numeroVagas;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "VagaModalidadeId", referencedColumnName = "VagaModalidadeId")
    private VagaModalidadeEntity modalidade;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "VagaRegimeId", referencedColumnName = "VagaRegimeId")
    private VagaRegimeEntity regime;
	
	@OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
    private List<VagaBeneficioEntity> beneficios;
	
	@OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
    private List<VagaRequisitoEntity> requisitos;
	
	@OneToMany(mappedBy = "vaga")
    private List<VagaCandidaturaEntity> candidaturas;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getVagaId() {
		return vagaId;
	}

	public void setVagaId(Long vagaId) {
		this.vagaId = vagaId;
	}

	public RecrutadorEntity getRecrutador() {
		return recrutador;
	}

	public void setRecrutador(RecrutadorEntity recrutador) {
		this.recrutador = recrutador;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
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

	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}	

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public VagaModalidadeEntity getModalidade() {
		return modalidade;
	}

	public void setModalidade(VagaModalidadeEntity modalidade) {
		this.modalidade = modalidade;
	}

	public VagaRegimeEntity getRegime() {
		return regime;
	}

	public void setRegime(VagaRegimeEntity regime) {
		this.regime = regime;
	}

	public List<VagaBeneficioEntity> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<VagaBeneficioEntity> beneficios) {
		this.beneficios = beneficios;
	}

	public List<VagaRequisitoEntity> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<VagaRequisitoEntity> requisitos) {
		this.requisitos = requisitos;
	}

	public List<VagaCandidaturaEntity> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(List<VagaCandidaturaEntity> candidaturas) {
		this.candidaturas = candidaturas;
	}
	
}
