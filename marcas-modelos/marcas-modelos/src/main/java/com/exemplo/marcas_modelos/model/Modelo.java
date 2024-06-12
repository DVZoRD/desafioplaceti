package com.exemplo.marcas_modelos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Modelo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int ano;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;



}
