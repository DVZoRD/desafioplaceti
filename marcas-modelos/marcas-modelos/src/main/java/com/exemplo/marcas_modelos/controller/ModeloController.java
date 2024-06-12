package com.exemplo.marcas_modelos.controller;

import com.exemplo.marcas_modelos.model.Modelo;
import com.exemplo.marcas_modelos.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping
    public List<Modelo> getAllModelos() {
        return modeloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getModeloById(@PathVariable(value = "id") Long modeloId) {
        return modeloRepository.findById(modeloId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Modelo createModelo(@RequestBody Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> updateModelo(@PathVariable(value = "id") Long modeloId,
                                               @RequestBody Modelo modeloDetails) {
        return modeloRepository.findById(modeloId)
                .map(modelo -> {
                    modelo.setNome(modeloDetails.getNome());
                    modelo.setAno(modeloDetails.getAno());
                    modelo.setAtivo(modeloDetails.isAtivo());
                    modelo.setMarca(modeloDetails.getMarca());
                    Modelo updatedModelo = modeloRepository.save(modelo);
                    return ResponseEntity.ok(updatedModelo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteModelo(@PathVariable(value = "id") Long modeloId) {
        return modeloRepository.findById(modeloId)
                .map(modelo -> {
                    modeloRepository.delete(modelo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
