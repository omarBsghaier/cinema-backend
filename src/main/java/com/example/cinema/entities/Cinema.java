package com.example.cinema.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cinema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private Double longitude , latitude , altitude ;
    private int nombreSalles ;
    @OneToMany(mappedBy ="cinema")
    private Collection<Salle> salles ;
    @ManyToOne
    private Ville ville ;




}
