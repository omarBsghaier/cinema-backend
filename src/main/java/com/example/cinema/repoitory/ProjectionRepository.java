package com.example.cinema.repoitory;

import com.example.cinema.entities.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProjectionRepository extends JpaRepository <Projection,Long > {
}
