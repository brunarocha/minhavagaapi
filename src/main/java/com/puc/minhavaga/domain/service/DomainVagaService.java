package com.puc.minhavaga.domain.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.minhavaga.domain.Candidato;
import com.puc.minhavaga.domain.Recrutador;
import com.puc.minhavaga.domain.Vaga;
import com.puc.minhavaga.domain.VagaCandidatura;
import com.puc.minhavaga.infrastructure.exception.BadRequestException;
import com.puc.minhavaga.infrastructure.exception.NotFoundException;

@Service
public class DomainVagaService implements VagaService {
	
	@Autowired
	private VagaPersistence vagaPersistence;
	
	@Autowired
	private RecrutadorPersistence recrutadorPersistence;
	
	@Autowired
	private CandidatoPersistence candidatoPersistence;
	
	@Override
	public List<Vaga> all(Map<String,String> params) {		
		return vagaPersistence.findAll(params);
	}
	
	@Override
	public Vaga findById(Long id) throws Exception {
		return vagaPersistence.findByVagaId(id);
	}
	
	@Override
	public Vaga create(Vaga vaga) throws Exception {		
		Recrutador existing = recrutadorPersistence.findByRecrutadorId(vaga.getRecrutador().getRecrutadorId());
		
		if (existing == null) {
			throw new BadRequestException("RecrutadorId", "Recrutador não existente!");
		}
				
		vaga.open();
		
		return vagaPersistence.create(vaga);
	}
	
	@Override
	public Vaga update(Long id, Vaga vaga) throws Exception {
		Vaga found = vagaPersistence.findByVagaId(id);
		
		if (found == null) {
			throw new NotFoundException();
		}
		
		return vagaPersistence.update(id, vaga);
	}
	
	@Override
	public void delete(Long id) throws Exception {
		Vaga found = vagaPersistence.findByVagaId(id);
		if (found == null) {
			throw new NotFoundException();
		}
		
		vagaPersistence.delete(id);
	}
	
	@Override
	public VagaCandidatura create(VagaCandidatura candidatura) throws Exception {
		Vaga foundVaga = vagaPersistence.findByVagaId(candidatura.getVaga().getVagaId());
		Candidato foundCandidato = candidatoPersistence.findByCandidatoId(candidatura.getCandidato().getCandidatoId());
		
		if (foundVaga == null || foundCandidato == null) {
			throw new NotFoundException();
		}
		
		candidatura.sent();
		
		return vagaPersistence.create(candidatura);
	}
	
	@Override
	public VagaCandidatura update(Long id, VagaCandidatura candidatura) throws Exception {
		candidatura.setVaga(new Vaga(id));
		
		Vaga foundVaga = vagaPersistence.findByVagaId(id);
		Candidato foundCandidato = candidatoPersistence.findByCandidatoId(candidatura.getCandidato().getCandidatoId());
		
		if (foundVaga == null || foundCandidato == null) {
			throw new NotFoundException();
		}
		
		return vagaPersistence.update(id, candidatura);
	}
	
}