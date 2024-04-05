package com.Gerenciamento.Petshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Gerenciamento.Petshop.model.Animal;
import com.Gerenciamento.Petshop.service.AnimalService;

@RequestMapping("/animais")
@RestController
public class AnimalController {
    private AnimalService animalService;

    @PostMapping("/cadastrar")
    public String cadastrarAnimal(@RequestParam("tipo") String tipo,
                                  @RequestParam("nome") String nome,
                                  @RequestParam("raca") String raca,
                                  @RequestParam("idade") int idade) {
        Animal animal = new Animal(tipo, nome, raca, idade);
        animalService.cadastrarAnimal(animal);
        return "redirect:/Servico.html";
    }

    @GetMapping("/static/Servico.html")
    public String redirectToOutraPagina() {
        return "/static/Servico.html";
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
