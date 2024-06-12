package com.exemplo.marcas_modelos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Marca {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigoDenatran;
    private boolean ativo;

    @OneToMany(mappedBy = "marca" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Modelo> modelos;

}
