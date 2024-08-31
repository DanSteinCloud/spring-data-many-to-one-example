package com.emura_group.togo_zones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emura_group.togo_zones.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
	  List<Region> findByRegionName(String region_name);

	  List<Region> findByRegionMainCrop(String crop);

}
