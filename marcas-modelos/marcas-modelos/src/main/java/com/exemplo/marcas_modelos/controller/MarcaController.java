package com.exemplo.marcas_modelos.controller;


import com.exemplo.marcas_modelos.model.Marca;
import com.exemplo.marcas_modelos.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<Marca> getAllMarcas(){
        return marcaRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable(value = "id") Long marcaId){
        return marcaRepository.findById(marcaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Marca createMarca(@RequestBody Marca marca){
        return marcaRepository.save(marca);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Marca>updateMarca(@PathVariable(value = "id") Long marcaId, @RequestBody Marca marcaDetails){
        return marcaRepository.findById(marcaId).map(marca -> {
            marca.setNome(marcaDetails.getNome());
            marca.setCodigoDenatran(marcaDetails.getCodigoDenatran());
            marca.setAtivo(marcaDetails.isAtivo());
            marca.setModelos(marcaDetails.getModelos());
            Marca updatedMarca = marcaRepository.save(marca);
            return ResponseEntity.ok(updatedMarca);
        })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteModelo(@PathVariable(value = "id") Long modeloId) {
        try {
            Marca marca = marcaRepository.findById(modeloId).orElseThrow(() -> new RuntimeException("Modelo not found"));
            marcaRepository.delete(marca);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
