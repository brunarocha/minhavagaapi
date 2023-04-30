package com.puc.minhavaga.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.puc.minhavaga.infrastructure.security.AuthEntryPointJwt;
import com.puc.minhavaga.infrastructure.security.AuthTokenFilter;
import com.puc.minhavaga.infrastructure.security.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsServiceImpl);
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
	        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	        
	        // Our public endpoints
	        .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/usuarios/").permitAll()
	        .antMatchers(HttpMethod.POST, "/usuarios/login").permitAll()
	        .antMatchers(HttpMethod.POST, "/usuarios/profile/").permitAll()
	        .antMatchers(HttpMethod.GET, "/vagas/").permitAll()
	        .antMatchers(HttpMethod.GET, "/vagas/{id}").permitAll()
	        .antMatchers("/api/test/**").permitAll()
            // Our private endpoints
            .anyRequest().authenticated();
	    
	    http.authenticationProvider(authenticationProvider());

	    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
	  }
}
