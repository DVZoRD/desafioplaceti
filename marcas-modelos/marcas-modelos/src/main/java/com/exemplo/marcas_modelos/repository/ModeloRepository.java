package com.exemplo.marcas_modelos.repository;

import com.exemplo.marcas_modelos.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
