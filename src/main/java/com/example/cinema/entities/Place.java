package com.example.cinema.entities;

import com.example.cinema.entities.Salle;
import com.example.cinema.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor@AllArgsConstructor
public class Place {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  int numero ;
    private  Double longitude ,  latidude , altitude ;
    @ManyToOne
    private Salle salle ;
    @OneToMany(mappedBy = "place")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets ;

}
