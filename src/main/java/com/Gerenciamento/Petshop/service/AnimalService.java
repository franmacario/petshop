package com.Gerenciamento.Petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gerenciamento.Petshop.model.Animal;
import com.Gerenciamento.Petshop.repository.AnimalRepository;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> listarAnimais(){
        return animalRepository.findAll();
    }
    public Animal cadastrarAnimal(Animal animal){
        return animalRepository.save(animal);
    }
    public Animal buscarAnimalPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }
}
