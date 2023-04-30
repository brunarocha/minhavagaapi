package com.puc.minhavaga.infrastructure.adapter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.puc.minhavaga.domain.Vaga;
import com.puc.minhavaga.domain.VagaCandidatura;
import com.puc.minhavaga.domain.service.VagaPersistence;
import com.puc.minhavaga.infrastructure.mapper.VagaMapper;
import com.puc.minhavaga.infrastructure.repository.VagaBeneficioRepository;
import com.puc.minhavaga.infrastructure.repository.VagaCandidaturaEntity;
import com.puc.minhavaga.infrastructure.repository.VagaCandidaturaRepository;
import com.puc.minhavaga.infrastructure.repository.VagaEntity;
import com.puc.minhavaga.infrastructure.repository.VagaRepository;
import com.puc.minhavaga.infrastructure.repository.VagaRequisitoRepository;

@Component
public class VagaJPAAdapter implements VagaPersistence {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private VagaBeneficioRepository beneficioRepository;
	
	@Autowired
	private VagaRequisitoRepository requisitoRepository;
	
	@Autowired
	private VagaCandidaturaRepository candidaturaRepository;
	
	@Autowired
	private VagaMapper mapper;
		
	@Override
	public List<Vaga> findAll(Map<String,String> params) {
		final int SEARCH_SIZE = 15;
		
		int page = 0;
		String cargo = null;
		Long vagaModalidadeId = null;
		
		if (params != null && params.size() > 0) {
			page = params.get("page") != null ? Integer.parseInt(params.get("page")) : page;
			cargo = params.get("cargo").isEmpty() ? "" : params.get("cargo");
			vagaModalidadeId = params.get("vagaModalidadeId") == null ? null : Long.parseLong(params.get("vagaModalidadeId"));
		}		
		
		PageRequest pageRequest = PageRequest.of(page, SEARCH_SIZE, Sort.by(Sort.Direction.DESC, "vagaId"));
		
		Page<VagaEntity> results = vagaRepository.findBy(cargo, vagaModalidadeId, pageRequest);
		
		return mapper.vagasToDTO(results.getContent());
	}
	
	@Override
	public Vaga create(Vaga vaga) {
		VagaEntity entity = vagaRepository.save(mapper.vagaToEntity(vaga, null));
		
		return mapper.vagaToDTO(entity);
	}
	
	@Override
	public Vaga update(Long id, Vaga vaga) {
		beneficioRepository.deleteByVagaVagaId(id);
		requisitoRepository.deleteByVagaVagaId(id);
		
		VagaEntity found = this.findById(id);
		VagaEntity updated = vagaRepository.save(mapper.vagaToEntity(vaga, found));
		
		return mapper.vagaToDTO(updated);
	}
	
	@Override
	public void delete(Long id) throws Exception {
		beneficioRepository.deleteByVagaVagaId(id);
		requisitoRepository.deleteByVagaVagaId(id);
				
		vagaRepository.deleteById(id);
	}
	
	@Override
	public VagaCandidatura create(VagaCandidatura candidatura) {
		VagaCandidaturaEntity entity = candidaturaRepository.save(mapper.candidaturaToEntity(candidatura));
		
		return mapper.candidaturaToDTO(entity);
	}	

	@Override
	public VagaCandidatura update(Long id, VagaCandidatura candidatura) {
		VagaCandidaturaEntity entity = candidaturaRepository.save(mapper.candidaturaToEntity(candidatura));
		
		return mapper.candidaturaToDTO(entity);
	}
	
	@Override
	public Vaga findByVagaId(Long vagaId) {
		VagaEntity found = this.findById(vagaId);
		
		return mapper.vagaToDTO(found);
	}
	
	private VagaEntity findById(Long vagaId) {
		return vagaRepository.findById(vagaId).orElse(null);
	}

}
