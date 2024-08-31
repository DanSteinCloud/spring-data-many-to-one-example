CREATE TABLE [IF NOT EXISTS] region
(
 id int NOT NULL,
 region_name varchar(100) NOT NULL,
 description varchar(100) NOT NULL,
 region_population int,
 region_men_population int,
 region_women_population int,
 region_children_population int,
 region_main_crop varchar(100),
 PRIMARY KEY (id)
);

INSERT INTO location.region (id, region_name, description, region_population, region_men_population, region_women_population, region_children_population, region_main_crop)
VALUES
  (1, 'Maritime', 'Region maritime', 3967, 1357, 1388, 1968, 'Riz'),
  (2, 'Plateau', 'Region des plateaux', 3967, 1357, 1388, 1968, 'Igname'),
  (3, 'Centrale', 'Region centrale', 3967, 1357, 1388, 1968, 'Mil'),
  (4, 'Kara', 'Region de la Kara', 3967, 1357, 1388, 1968, 'Mil'),
  (5, 'Savane', 'Region des savanes', 3967, 1357, 1388, 1968, 'Sorgho');
  

  
  
CREATE TABLE [IF NOT EXISTS] commune
(
 id int NOT NULL,
 region_name varchar(100) NOT NULL,
 description varchar(100) NOT NULL,
 region_population int,
 region_men_population int,
 region_women_population int,
 region_children_population int,
 region_main_crop varchar(100),
 PRIMARY KEY (id)
);

INSERT INTO location.commune (id, commune_name, description, commune_population, 
commune_men_population, commune_women_population, commune_children_population, commune_main_crop, region_id)
VALUES
  (1, 'Be', 'Region maritime', 3967, 1357, 1388, 1968, 'Riz', 1),
  (2, 'Aflao', 'Region maritime', 3967, 1357, 1388, 1968, 'Mais', 1),
  (3, 'Afagnan', 'Region maritime', 3967, 1357, 1388, 1968, 'Manioc', 1),
  (4, 'Klikame', 'Region maritime', 3967, 1357, 1388, 1968, 'Riz', 1),
  (5, 'Kouve', 'Region maritime', 3967, 1357, 1388, 1968, 'Mais', 1);