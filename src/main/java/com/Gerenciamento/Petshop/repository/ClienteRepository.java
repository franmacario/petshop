package com.Gerenciamento.Petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gerenciamento.Petshop.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
