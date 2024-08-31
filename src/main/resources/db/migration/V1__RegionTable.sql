CREATE TABLE region
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



