package com.puc.minhavaga.application.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.minhavaga.application.request.LoginRequest;
import com.puc.minhavaga.application.request.UsuarioProfileRequest;
import com.puc.minhavaga.application.request.UsuarioRequest;
import com.puc.minhavaga.application.response.LoginResponse;
import com.puc.minhavaga.application.response.UsuarioResponse;
import com.puc.minhavaga.domain.Usuario;
import com.puc.minhavaga.domain.service.UsuarioService;
import com.puc.minhavaga.infrastructure.exception.BadRequestException;
import com.puc.minhavaga.infrastructure.exception.InternalServerErrorException;
import com.puc.minhavaga.infrastructure.exception.NotFoundException;
import com.puc.minhavaga.infrastructure.security.JWTUtils;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody final LoginRequest request) throws Exception {
		try {
			UsernamePasswordAuthenticationToken usuario = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha());
			
			Authentication authentication = usuarioService.login(usuario);
			
		    SecurityContextHolder.getContext().setAuthentication(authentication);
		    String jwt = jwtUtils.generateJwtToken(authentication);
		    
		    Usuario authenticated = (Usuario) authentication.getPrincipal();
		    
		    return ResponseEntity.ok(new LoginResponse(jwt, authenticated.getEmail(), authenticated.getProfile()));
		} catch (UsernameNotFoundException | BadCredentialsException bce) {
			throw bce;
		} catch (Exception e) {
			throw new InternalServerErrorException("Falha inesperada ao realizar login!");
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> create(@Valid @RequestBody final UsuarioRequest request) throws Exception {
		try {
			Usuario created = usuarioService.create(request.parse());
			
			UsuarioResponse response = new UsuarioResponse(created);
			
			return ResponseEntity.created(null).body(response);
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			throw new InternalServerErrorException("Falha inesperada ao criar usuário!");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@Valid @PathVariable Long id, @RequestBody final UsuarioRequest request) throws Exception {
		try {
			Usuario updated = usuarioService.update(id, request.parse());
			
			UsuarioResponse response = new UsuarioResponse(updated);
			
			return ResponseEntity.ok().body(response);
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			throw new InternalServerErrorException("Falha inesperada ao atualizar usuário!");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception {
		try {
			usuarioService.delete(id);
			
			return ResponseEntity.noContent().build();
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Falha inesperada ao excluir usuário!");
		}
	}
	
	@PostMapping("/profile")
	public ResponseEntity<Object> profile(@Valid @RequestBody final UsuarioProfileRequest usuario) throws Exception {
		try {
			if (usuario.isEmptyData()) {
				throw new BadRequestException("Dados do usuário não enviados!");
			}
			
			if (usuario.isCandidato()) {
				return ResponseEntity.created(null).body(usuarioService.create(usuario.getCandidato()));
			} else if (usuario.isRecrutador()) {				
				return ResponseEntity.created(null).body(usuarioService.create(usuario.getRecrutador()));
			}
			
			throw new BadRequestException("Perfil de usuário não encontrado!");
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			throw new InternalServerErrorException("Falha inesperada ao criar perfil!");
		}
	}
	
	@PutMapping("/profile/{id}")
	public ResponseEntity<Object> profile(@Valid @PathVariable Long id,  @RequestBody final UsuarioProfileRequest usuario) throws Exception {
		try {
			if (usuario.isEmptyData()) {
				throw new BadRequestException("Dados do usuário não enviados!");
			}
			
			if (usuario.isCandidato()) {
				return ResponseEntity.ok().body(usuarioService.update(id, usuario.getCandidato()));
			} else if (usuario.isRecrutador()) {				
				return ResponseEntity.ok().body(usuarioService.create(usuario.getRecrutador()));
			}
			
			throw new BadRequestException("Perfil de usuário não encontrado!");
		} catch (BadRequestException | NotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			throw new InternalServerErrorException("Falha inesperada ao atualizar perfil!");
		}		
	}
	
}