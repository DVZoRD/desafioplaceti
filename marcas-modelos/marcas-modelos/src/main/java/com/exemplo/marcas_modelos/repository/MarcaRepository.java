package com.exemplo.marcas_modelos.repository;

import com.exemplo.marcas_modelos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
