package com.example.cinema.dao;

import com.example.cinema.entities.Cinema;
import com.example.cinema.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepository extends JpaRepository <Place,Long > {
}
