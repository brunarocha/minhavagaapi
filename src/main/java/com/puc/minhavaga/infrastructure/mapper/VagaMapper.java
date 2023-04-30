package com.puc.minhavaga.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.puc.minhavaga.domain.Vaga;
import com.puc.minhavaga.domain.VagaCandidatura;
import com.puc.minhavaga.domain.VagaCandidaturaStatus;
import com.puc.minhavaga.domain.VagaRequisito;
import com.puc.minhavaga.infrastructure.repository.CandidatoEntity;
import com.puc.minhavaga.infrastructure.repository.RecrutadorEntity;
import com.puc.minhavaga.infrastructure.repository.VagaBeneficioEntity;
import com.puc.minhavaga.infrastructure.repository.VagaCandidaturaEntity;
import com.puc.minhavaga.infrastructure.repository.VagaEntity;
import com.puc.minhavaga.infrastructure.repository.VagaModalidadeEntity;
import com.puc.minhavaga.infrastructure.repository.VagaRegimeEntity;
import com.puc.minhavaga.infrastructure.repository.VagaRequisitoEntity;
import com.puc.minhavaga.infrastructure.repository.VagaCandidaturaEntity.VagaCandidaturaEntityKey;

@Component
public class VagaMapper {
	
	public List<Vaga> vagasToDTO(List<VagaEntity> entities) {
		List<Vaga> dtos = new ArrayList<Vaga>();
		
		if (entities == null) {
			return null;
		}
		
		for (VagaEntity entity : entities) {
			dtos.add(this.vagaToDTO(entity));
		}
		
		return dtos;
	}
	
	public Vaga vagaToDTO(VagaEntity entity) {
		if (entity == null) {
			return null;
		}
		
		List<String> beneficios = this.beneficiosToDTO(entity.getBeneficios());
		List<VagaRequisito> requisitos = this.requisitosToDTO(entity.getRequisitos());
		
		return new Vaga(entity.getVagaId(), null, entity.getCargo(), entity.getDescricao(), entity.getEmpresa(), 
				entity.getLocal(), entity.getFaixaSalarialMin(), entity.getFaixaSalarialMax(), entity.getNumeroVagas(),
				entity.getDataInicio(), entity.getDataFim(), entity.getModalidade().getVagaModalidadeId(), 
				entity.getRegime().getVagaRegimeId(), beneficios, requisitos, null);
	}
	
	public VagaEntity vagaToEntity(Vaga dto, VagaEntity entity) {
		if (entity == null) {
			entity = new VagaEntity();
		}
				
		entity.setRecrutador(new RecrutadorEntity(dto.getRecrutador().getRecrutadorId()));
		entity.setCargo(dto.getCargo());
		entity.setDescricao(dto.getDescricao());
		entity.setEmpresa(dto.getEmpresa());
		entity.setLocal(dto.getLocal());
		entity.setFaixaSalarialMin(dto.getFaixaSalarialMin());
		entity.setFaixaSalarialMax(dto.getFaixaSalarialMax());
		entity.setNumeroVagas(dto.getNumeroVagas());
		
		entity.setDataInicio(dto.getDataInicio());
		entity.setDataFim(dto.getDataFim());
		entity.setModalidade(new VagaModalidadeEntity(dto.getModalidadeId()));
		entity.setRegime(new VagaRegimeEntity(dto.getRegimeId()));
		
		if (dto.getBeneficios() != null) {
			entity.setBeneficios(this.beneficiosToEntity(entity, dto.getBeneficios()));
		}
		
		if (dto.getRequisitos() != null) {
			entity.setRequisitos(this.requisitosToEntity(entity, dto.getRequisitos()));
		}
		
		entity.setCandidaturas(null);
				
		return entity;
	}
	
	public List<VagaBeneficioEntity> beneficiosToEntity(VagaEntity entity, List<String> dtos) {
		List<VagaBeneficioEntity> entities = new ArrayList<>();
		
		for (String dto : dtos) {
			entities.add(new VagaBeneficioEntity(entity, dto));
		}
		
		return entities;
	}
	
	public List<VagaRequisitoEntity> requisitosToEntity(VagaEntity entity, List<VagaRequisito> dtos) {
		List<VagaRequisitoEntity> entities = new ArrayList<>();
		
		for (VagaRequisito dto : dtos) {
			entities.add(new VagaRequisitoEntity(entity, dto.getRequisito(), dto.getRequisitoObrigatorio()));
		}
		
		return entities;
	}
	
	public List<String> beneficiosToDTO(List<VagaBeneficioEntity> entities) {
		List<String> dtos = new ArrayList<>();
		
		if (entities != null) {
			for (VagaBeneficioEntity entity : entities) {
				dtos.add(entity.getBeneficio());
			}
		}
		
		return dtos;
	}
	
	public List<VagaRequisito> requisitosToDTO(List<VagaRequisitoEntity> entities) {
		List<VagaRequisito> dtos = new ArrayList<>();
		
		if (entities != null) {
			for (VagaRequisitoEntity entity : entities) {
				dtos.add(new VagaRequisito(entity.getRequisito(), entity.getRequisitoObrigatorio()));
			}
		}
		
		return dtos;
	}
	
	public VagaCandidaturaEntity candidaturaToEntity(VagaCandidatura dto) {
		CandidatoEntity candidato = new CandidatoEntity();
		candidato.setCandidatoId(dto.getCandidato().getCandidatoId());
		
		VagaEntity vaga = new VagaEntity();
		vaga.setVagaId(dto.getVaga().getVagaId());
		
		VagaCandidaturaEntityKey key = new VagaCandidaturaEntityKey();
		key.setCandidatoId(dto.getCandidato().getCandidatoId());
		key.setVagaId(dto.getVaga().getVagaId());
		
		VagaCandidaturaEntity entity = new VagaCandidaturaEntity();
		entity.setPk(key);
		entity.setCandidato(candidato);
		entity.setVaga(vaga);
		entity.setStatus(dto.getStatus().name());
		entity.setFeedback(dto.getFeedback());
				
		return entity;
	}
	
	public VagaCandidatura candidaturaToDTO(VagaCandidaturaEntity entity) {
		return new VagaCandidatura(this.vagaToDTO(entity.getVaga()), null, VagaCandidaturaStatus.valueOf(entity.getStatus()), entity.getFeedback());
	}


}
