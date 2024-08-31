package com.emura_group.togo_zones.model;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "commune", schema="location")
@Getter
@Setter
@Data
public class Commune implements Serializable {

  private static final long serialVersionUID = 1L;

@Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commune_generator")
  private long id;
  
  @Column(name = "commune_name")
  private String communeName;

  @Column(name = "description")
  private String description;

  @Column(name = "commune_population")
  private String commune_population;
  
  @Column(name = "commune_men_population")
  private String commune_men_population;
  
  @Column(name = "commune_women_population")
  private String commune_women_population;
  
  @Column(name = "commune_children_population")
  private String commune_children_population;
  
  @Column(name = "commune_main_crop")
  private String communeMainCrop;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "region_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Region region;


}