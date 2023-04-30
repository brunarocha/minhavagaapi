package com.puc.minhavaga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.puc.minhavaga.infrastructure.repository")
@EntityScan("com.puc.minhavaga.infrastructure.repository")
public class MinhaVagaApplication  {

	public static void main(String[] args) {		
		SpringApplication application = new SpringApplication(MinhaVagaApplication.class);
        application.run(args);
	}
}
