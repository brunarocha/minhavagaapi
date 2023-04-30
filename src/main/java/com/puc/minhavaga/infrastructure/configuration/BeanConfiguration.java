package com.puc.minhavaga.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.puc.minhavaga.domain.service.DomainUsuarioService;
import com.puc.minhavaga.domain.service.DomainVagaService;
import com.puc.minhavaga.domain.service.UsuarioPersistence;
import com.puc.minhavaga.domain.service.UsuarioService;
import com.puc.minhavaga.domain.service.VagaPersistence;
import com.puc.minhavaga.domain.service.VagaService;
import com.puc.minhavaga.infrastructure.adapter.UsuarioJPAAdapter;
import com.puc.minhavaga.infrastructure.adapter.VagaJPAAdapter;

@Configuration
public class BeanConfiguration {
	
	@Bean
    public UsuarioPersistence usuarioPersistence() {
        return new UsuarioJPAAdapter();
    }
	
	@Bean
	public UsuarioService usuarioService() {
		return new DomainUsuarioService();
	}
	
	@Bean
	public VagaPersistence vagaPersistence() {
		return new VagaJPAAdapter();
	}
	
	@Bean
	public VagaService vagaService() {
		return new DomainVagaService();
	}
	
}
