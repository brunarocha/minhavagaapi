package com.puc.minhavaga.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.puc.minhavaga.infrastructure.repository.VagaEntity;

@Repository
public interface VagaRepository extends PagingAndSortingRepository<VagaEntity, Long> {
	
	Page<VagaEntity> findByCargoContaining(String cargo, Pageable pageable);
	
	@Query("SELECT v FROM VagaEntity v WHERE (:cargo is null or v.cargo LIKE CONCAT('%',:cargo,'%')) "
			+ " and (:vagaModalidadeId is null or v.modalidade.vagaModalidadeId = :vagaModalidadeId) ")
	Page<VagaEntity> findBy(@Param("cargo") String name, @Param("vagaModalidadeId") Long vagaModalidadeId, Pageable pageable);
	
}
