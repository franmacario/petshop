package com.Gerenciamento.Petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gerenciamento.Petshop.model.Animal;

public interface AnimalRepository extends JpaRepository <Animal, Long>{

}
