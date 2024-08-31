package com.emura_group.togo_zones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emura_group.togo_zones.model.Commune;

import jakarta.transaction.Transactional;

public interface CommuneRepository extends JpaRepository<Commune, Long> {
	List<Commune> findByRegionId(Long regionId);
	  
	@Transactional
	void deleteByRegionId(long regionId);
}
