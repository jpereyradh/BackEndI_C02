package com.example.DirectorTecnico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String clubFavorito;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private DirectorTecnico directorTecnico;
}
