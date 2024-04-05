package com.Gerenciamento.Petshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gerenciamento.Petshop.model.Animal;
import com.Gerenciamento.Petshop.service.AnimalService;

@RequestMapping("/animais")
@RestController
public class AnimalController {
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<Animal> cadastrarAnimal(@RequestBody Animal animal){
        Animal novoAnimal= animalService.cadastrarAnimal(animal);
        return new ResponseEntity<>(novoAnimal, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Animal>> listarAnimais(){
        List<Animal> animais = animalService.listarAnimais();
        return new ResponseEntity<>(animais, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarAnimalPorId(@PathVariable Long id) {
        listarAnimais();
        Animal animal = animalService.buscarAnimalPorId(id);
        if (animal != null) {
            return ResponseEntity.ok(animal); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
}
