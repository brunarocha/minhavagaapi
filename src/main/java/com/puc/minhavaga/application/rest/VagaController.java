package com.puc.minhavaga.application.rest;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.minhavaga.application.request.VagaCandidaturaRequest;
import com.puc.minhavaga.application.request.VagaRequest;
import com.puc.minhavaga.domain.Vaga;
import com.puc.minhavaga.domain.VagaCandidatura;
import com.puc.minhavaga.domain.service.VagaService;
import com.puc.minhavaga.infrastructure.exception.BadRequestException;
import com.puc.minhavaga.infrastructure.exception.InternalServerErrorException;
import com.puc.minhavaga.infrastructure.exception.NotFoundException;

@RestController
@RequestMapping("/vagas")
public class VagaController {
	
	@Autowired
	private VagaService vagaService;

	@GetMapping("/")	
	public ResponseEntity<Object> get(@RequestParam Map<String,String> params) throws Exception {
		try {
			List<Vaga> results = vagaService.all(params);
			
			return ResponseEntity.ok(results);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Falha inesperada ao consultar vagas!");
		}
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<Object> getById(@PathVariable Long id) throws Exception {
		try {
			Vaga found = vagaService.findById(id);
			
			return ResponseEntity.ok(found);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Falha inesperada ao consultar vaga!");
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> create(@Valid @RequestBody final VagaRequest request) throws Exception {
		try {
			Vaga created = vagaService.create(request.parse());
			
			return ResponseEntity.created(null).body(created);
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			throw new InternalServerErrorException("Falha inesperada ao cadastrar vaga!");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@Valid @PathVariable Long id, @RequestBody final VagaRequest request) throws Exception  {
		try {
			Vaga updated = vagaService.update(id, request.parse());
			
			return ResponseEntity.ok().body(updated);			
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Falha inesperada ao atualizar vaga!");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception {
		try {
			vagaService.delete(id);
			
			return ResponseEntity.noContent().build();
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Falha inesperada ao excluir vaga!");
		}
	}
	
	@PostMapping("/candidatura")
	public ResponseEntity<Object> create(@Valid @RequestBody final VagaCandidaturaRequest request) throws Exception {
		try {
			VagaCandidatura created = vagaService.create(request.parse());
			
			return ResponseEntity.created(null).body(created);
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			throw new InternalServerErrorException("Falha inesperada ao aplicar candidatura!");
		}
	}
	
	@PutMapping("/candidatura/{id}")
	public ResponseEntity<Object> update(@Valid @PathVariable Long id, @RequestBody final VagaCandidaturaRequest request) throws Exception {
		try {
			VagaCandidatura updated = vagaService.update(id, request.parse());
			
			return ResponseEntity.ok().body(updated);
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			throw new InternalServerErrorException("Falha inesperada ao atualizar candidatura!");
		}
	}
}
