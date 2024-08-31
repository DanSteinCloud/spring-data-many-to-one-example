package com.emura_group.togo_zones.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.emura_group.togo_zones.model.Region;
import com.emura_group.togo_zones.repository.RegionRepository;

public abstract class RegionRepositoryImpl implements RegionRepository {
	
	@Autowired
	RegionRepository regionRepository;
	
	public static List<Region> DB = new ArrayList<>();
	
	public List<Region> findByRegion_name(String region_name){
		List<Region> regions = regionRepository.findAll().stream()
		          .filter(reg -> reg.regionName.equals(region_name))
		          .collect(Collectors.toList()); 
		return regions;
		
	};

	  public List<Region> findByRegion_main_crop(String crop){
		  List<Region> regions = regionRepository.findAll().stream()
		          .filter(reg -> reg.regionMainCrop.equals(crop))
		          .collect(Collectors.toList()); 
		return regions;
};

}
