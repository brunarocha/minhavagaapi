package com.puc.minhavaga.infrastructure.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.puc.minhavaga.domain.Usuario;
import com.puc.minhavaga.domain.service.UsuarioPersistence;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioPersistence usuarioPersistence;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = null;
		try {
			user = usuarioPersistence.findByEmail(username);
		} catch (Exception e) {
			return null;
		}
					
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		
		return user;
	}

}