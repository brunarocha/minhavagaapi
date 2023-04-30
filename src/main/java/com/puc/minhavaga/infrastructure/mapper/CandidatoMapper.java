package com.puc.minhavaga.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.puc.minhavaga.domain.Candidato;
import com.puc.minhavaga.domain.Experiencia;
import com.puc.minhavaga.domain.FormacaoAcademica;
import com.puc.minhavaga.domain.UsuarioProfile;
import com.puc.minhavaga.infrastructure.repository.CandidatoEntity;
import com.puc.minhavaga.infrastructure.repository.ExperienciaEntity;
import com.puc.minhavaga.infrastructure.repository.FormacaoAcademicaEntity;
import com.puc.minhavaga.infrastructure.repository.HabilidadeTecnicaEntity;
import com.puc.minhavaga.infrastructure.repository.UsuarioEntity;

@Component
public class CandidatoMapper {

	public CandidatoEntity candidatoToEntity(Candidato dto, CandidatoEntity entity) {
		if (entity == null) {
			entity = new CandidatoEntity();
		}
		
		entity.setUsuario(dto.getUsuarioId() != null ? new UsuarioEntity(dto.getUsuarioId()) : entity.getUsuario());
		entity.setArquivoCurriculo(dto.getArquivoCurriculo() != null ? dto.getArquivoCurriculo() : entity.getArquivoCurriculo());
		entity.setSobre(dto.getSobre() != null ? dto.getSobre() : entity.getSobre());
		entity.setCelular(dto.getCelular() != null ? dto.getCelular() : entity.getCelular());
		entity.setFaixaSalarialMin(dto.getFaixaSalarialMin() != null ? dto.getFaixaSalarialMin() : entity.getFaixaSalarialMin());
		entity.setFaixaSalarialMax(dto.getFaixaSalarialMax() != null ? dto.getFaixaSalarialMax() : entity.getFaixaSalarialMax());
		
		if (dto.getHabilidadesTecnicas() != null) {
			entity.setHabilidadesTecnicas(this.habilidadesTecnicasToEntity(dto.getHabilidadesTecnicas(), entity));
		}
		
		if (dto.getFormacoesAcademicas() != null ) {
			entity.setFormacoesAcademicas(this.formacoesAcademicasToEntity(dto.getFormacoesAcademicas(), entity));
		}
		
		if (dto.getExperiencias() != null) {
			entity.setExperiencias(this.experienciasToEntity(dto.getExperiencias(), entity));
		}
				
		return entity;
	}
	
	public Candidato candidatoToDTO(CandidatoEntity entity) {
		if (entity == null) {
			return null;
		}
		return new Candidato(entity.getUsuario().getUsuarioId(), UsuarioProfile.CANDIDATO, entity.getCandidatoId(), entity.getArquivoCurriculo(), 
				entity.getSobre(), entity.getCelular(), entity.getFaixaSalarialMin(), entity.getFaixaSalarialMax(), this.habilidadesTecnicasToDTO(entity.getHabilidadesTecnicas()),
				this.formacoesAcademicasToDTO(entity.getFormacoesAcademicas()), this.experienciasToDTO(entity.getExperiencias()));
	}
	
	public List<HabilidadeTecnicaEntity> habilidadesTecnicasToEntity(List<String> dtos, CandidatoEntity candidato) {
		List<HabilidadeTecnicaEntity> entities = new ArrayList<>();
		
		for (String dto : dtos) {
			entities.add(new HabilidadeTecnicaEntity(candidato, dto));
		}
		
		return entities;
	}
	
	public List<String> habilidadesTecnicasToDTO(List<HabilidadeTecnicaEntity> entities) {
		List<String> dtos = new ArrayList<>();
		
		if (entities != null) {
			for (HabilidadeTecnicaEntity entity : entities) {
				dtos.add(entity.getHabilidadeTecnica());
			}
		}
		
		return dtos;
	}
	
	public List<FormacaoAcademicaEntity> formacoesAcademicasToEntity(List<FormacaoAcademica> dtos, CandidatoEntity candidato) {
		List<FormacaoAcademicaEntity> entities = new ArrayList<>();
		
		for (FormacaoAcademica dto : dtos) {
			entities.add(new FormacaoAcademicaEntity(candidato, dto.getInstituicao(), dto.getCurso(), dto.getDataInicio(), dto.getDataFim()));
		}
		
		return entities;
	}
	
	public List<FormacaoAcademica> formacoesAcademicasToDTO(List<FormacaoAcademicaEntity> entities) {
		List<FormacaoAcademica> dtos = new ArrayList<>();
		
		if (entities != null) {
			for (FormacaoAcademicaEntity entity : entities) {
				dtos.add(new FormacaoAcademica(null, entity.getInstituicao(), entity.getCurso(), entity.getDataInicio(), entity.getDataFim()));
			}
		}
		
		return dtos;
	}
	
	public List<ExperienciaEntity> experienciasToEntity(List<Experiencia> dtos, CandidatoEntity candidato) {
		List<ExperienciaEntity> entities = new ArrayList<>();
		
		for (Experiencia dto : dtos) {
			entities.add(new ExperienciaEntity(candidato, dto.getEmpresa(), dto.getCargo(), dto.getDescricao(), dto.getDataInicio(), dto.getDataFim()));
		}
		
		return entities;
	}
	
	public List<Experiencia> experienciasToDTO(List<ExperienciaEntity> entities) {
		List<Experiencia> dtos = new ArrayList<>();
		
		if (entities != null) {
			for (ExperienciaEntity entity : entities) {
				dtos.add(new Experiencia(entity.getEmpresa(), entity.getCargo(), entity.getDescricao(),entity.getDataInicio(), entity.getDataFim()));
			}
		}		
		
		return dtos;
	}
}
