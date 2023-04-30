package com.puc.minhavaga.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puc.minhavaga.infrastructure.repository.ProfileEntity;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {
		
}
