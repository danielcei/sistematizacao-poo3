package com.petadota.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    private String nome;

    private String tipo;
    private Integer idade;
    private String raca;
    private String statusAdocao;
    private String imagem;
    private String descricao;

}