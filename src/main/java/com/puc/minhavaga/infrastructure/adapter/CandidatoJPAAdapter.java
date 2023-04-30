package com.puc.minhavaga.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puc.minhavaga.domain.Candidato;
import com.puc.minhavaga.domain.service.CandidatoPersistence;
import com.puc.minhavaga.infrastructure.mapper.CandidatoMapper;
import com.puc.minhavaga.infrastructure.repository.CandidatoEntity;
import com.puc.minhavaga.infrastructure.repository.CandidatoRepository;
import com.puc.minhavaga.infrastructure.repository.ExperienciaRepository;
import com.puc.minhavaga.infrastructure.repository.FormacaoAcademicaRepository;
import com.puc.minhavaga.infrastructure.repository.HabilidadeTecnicaRepository;

@Component
public class CandidatoJPAAdapter implements CandidatoPersistence {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired 
	private FormacaoAcademicaRepository formacaoAcademicaRepository;
	
	@Autowired
	private ExperienciaRepository experienciaRepository;
	
	@Autowired
	private HabilidadeTecnicaRepository habilidadeTecnicaRepository;
	
	@Autowired
	private CandidatoMapper mapper;

	@Override
	public Candidato create(Candidato candidato) throws Exception {
		CandidatoEntity created = candidatoRepository.saveAndFlush(mapper.candidatoToEntity(candidato, null));
		
		return mapper.candidatoToDTO(created);
	}

	@Override
	public Candidato update(Long id, Candidato candidato) throws Exception {
		formacaoAcademicaRepository.deleteByCandidatoCandidatoId(id);
		experienciaRepository.deleteByCandidatoCandidatoId(id);
		habilidadeTecnicaRepository.deleteByCandidatoCandidatoId(id);
		
		CandidatoEntity found = this.findById(id);
		CandidatoEntity updated = candidatoRepository.save(mapper.candidatoToEntity(candidato, found));
		
		return mapper.candidatoToDTO(updated);
	}
	
	@Override
	public void deleteByUsuarioId(Long usuarioId) throws Exception {
		CandidatoEntity found = candidatoRepository.findByUsuarioUsuarioId(usuarioId);
		Long candidatoId = found.getCandidatoId();
		
		formacaoAcademicaRepository.deleteByCandidatoCandidatoId(candidatoId);
		experienciaRepository.deleteByCandidatoCandidatoId(candidatoId);
		habilidadeTecnicaRepository.deleteByCandidatoCandidatoId(candidatoId);
		
		candidatoRepository.deleteById(candidatoId);
	}

	@Override
	public Candidato findByUsuarioId(Long usuarioId) throws Exception {
		CandidatoEntity found = candidatoRepository.findByUsuarioUsuarioId(usuarioId);
		
		return mapper.candidatoToDTO(found);
	}

	@Override
	public Candidato findByCandidatoId(Long id) throws Exception {		
		return mapper.candidatoToDTO(this.findById(id));
	}
	
	private CandidatoEntity findById(Long id) {
		return candidatoRepository.findByCandidatoId(id);
	}
	
}