package com.emura_group.togo_zones.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.emura_group.togo_zones.exception.ResourceNotFoundException;
import com.emura_group.togo_zones.model.Commune;
import com.emura_group.togo_zones.repository.CommuneRepository;
import com.emura_group.togo_zones.repository.RegionRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CommuneController {

  @Autowired
  private RegionRepository regionRepository;

  @Autowired
  private CommuneRepository communeRepository;

  @GetMapping("/regions/{regionId}/communes")
  public ResponseEntity<List<Commune>> getAllCommunesByRegionId(@PathVariable(value = "regionId") Long regionId) {
    if (!regionRepository.existsById(regionId)) {
      throw new ResourceNotFoundException("Not found Region with id = " + regionId);
    }

    List<Commune> commune = communeRepository.findByRegionId(regionId);
    return new ResponseEntity<>(commune, HttpStatus.OK);
  }

  @GetMapping("/communes/{id}")
  public ResponseEntity<Commune> getCommunesByRegionId(@PathVariable(value = "id") Long id) {
    Commune commune = communeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Commune with id = " + id));

    return new ResponseEntity<>(commune, HttpStatus.OK);
  }

  @PostMapping("/regions/{regionId}/communes")
  public ResponseEntity<Commune> createCommune(@PathVariable(value = "regionId") Long regionId,
      @RequestBody Commune communeRequest) {
    Commune commune = regionRepository.findById(regionId).map(region -> {
      communeRequest.setRegion(region);
      return communeRepository.save(communeRequest);
    }).orElseThrow(() -> new ResourceNotFoundException("Not found Region with id = " + regionId));

    return new ResponseEntity<>(commune, HttpStatus.CREATED);
  }

  @PutMapping("/communes/{id}")
  public ResponseEntity<Commune> updateCommune(@PathVariable("id") long id, @RequestBody Commune communeRequest) {
    Commune commune = communeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("CommuneId " + id + "not found"));

    commune.setDescription(communeRequest.getDescription());

    return new ResponseEntity<>(communeRepository.save(commune), HttpStatus.OK);
  }

  @DeleteMapping("/communes/{id}")
  public ResponseEntity<HttpStatus> deleteCommune(@PathVariable("id") long id) {
    communeRepository.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
  @DeleteMapping("/regions/{regionId}/communes")
  public ResponseEntity<List<Commune>> deleteAllCommunesOfRegion(@PathVariable(value = "regionId") Long regionId) {
    if (!regionRepository.existsById(regionId)) {
      throw new ResourceNotFoundException("Not found Region with id = " + regionId);
    }

    communeRepository.deleteByRegionId(regionId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}