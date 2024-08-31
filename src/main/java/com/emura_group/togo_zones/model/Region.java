package com.emura_group.togo_zones.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region", schema="location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Region implements Serializable {

  private static final long serialVersionUID = 1L;

@Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_generator")
  private long id;
  
  @Column(name = "region_name")
  public String regionName;
  
  @Column(name = "description")
  private String description;

  @Column(name = "region_population")
  private int region_population;
  
  @Column(name = "region_men_population")
  private int region_men_population;
  
  @Column(name = "region_women_population")
  private int region_women_population;
  
  @Column(name = "region_children_population")
  private int region_children_population;
  
  @Column(name = "region_main_crop")
  public String regionMainCrop;

//  public Region() {
//
//  }
//
//  public Region(String region_name, 
//		        String description, 
//		        String region_population,
//		        String region_men_population,
//		        String region_women_population,
//		        String region_children_population,
//		        String region_main_crop) {
//    this.region_name = region_name;
//    this.description = description;
//    this.region_population = region_population;
//    this.region_men_population = region_men_population;
//    this.region_women_population = region_women_population;
//    this.region_children_population = region_children_population;
//    this.region_main_crop = region_main_crop;
//  }

  // getters and setters
}