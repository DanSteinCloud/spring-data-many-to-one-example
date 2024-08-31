package com.emura_group.togo_zones.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emura_group.togo_zones.exception.ResourceNotFoundException;
import com.emura_group.togo_zones.model.Region;
import com.emura_group.togo_zones.repository.RegionRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RegionController {

  @Autowired
  RegionRepository regionRepository;

  @GetMapping("/regions")
  public ResponseEntity<List<Region>> getAllRegions(@RequestParam(required = false) String region_name) {
    List<Region> regions = new ArrayList<Region>();

    if (region_name == null)
      regionRepository.findAll().forEach(regions::add);
    else
      regionRepository.findByRegionName(region_name).forEach(regions::add);

    if (regions.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(regions, HttpStatus.OK);
  }

  @GetMapping("/regions/{id}")
  public ResponseEntity<Region> getRegionById(@PathVariable("id") long id) {
    Region region = regionRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Region with id = " + id));

    return new ResponseEntity<>(region, HttpStatus.OK);
  }

  @PostMapping("/regions")
  public ResponseEntity<Region> createRegion(@RequestBody Region region) {
    Region _region = regionRepository.save(new Region(5, region.getRegionName(),
    		                                          region.getDescription(),
    		                                          region.getRegion_population(),
    		                                          region.getRegion_men_population(),
    		                                          region.getRegion_women_population(),
    		                                          region.getRegion_children_population(),
    		                                          region.getRegionMainCrop()
    		                                          ));
    return new ResponseEntity<>(_region, HttpStatus.CREATED);
  }

  @PutMapping("/regions/{id}")
  public ResponseEntity<Region> updateRegion(@PathVariable("id") long id, @RequestBody Region region) {
    Region _region = regionRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Region with id = " + id));

    _region.setRegionName(region.getRegionName());
    _region.setDescription(region.getDescription());
    _region.setRegion_population(region.getRegion_population());
    _region.setRegion_men_population(region.getRegion_men_population());
    _region.setRegion_women_population(region.getRegion_women_population());
    _region.setRegion_children_population(region.getRegion_children_population());
    _region.setRegionMainCrop(region.getRegionMainCrop());
    
    return new ResponseEntity<>(regionRepository.save(_region), HttpStatus.OK);
  }

  @DeleteMapping("/regions/{id}")
  public ResponseEntity<HttpStatus> deleteRegion(@PathVariable("id") long id) {
    regionRepository.deleteById(id);
    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/regions")
  public ResponseEntity<HttpStatus> deleteAllRegions() {
    regionRepository.deleteAll();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } 

  @GetMapping("/regions-of/{crop}")
  public ResponseEntity<List<Region>> findRegionByCrops(@PathVariable("crop") String crop) {
    List<Region> regions = regionRepository.findByRegionMainCrop(crop);

    if (regions.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    return new ResponseEntity<>(regions, HttpStatus.OK);
  }
}