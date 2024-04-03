package com.Gerenciamento.Petshop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gerenciamento.Petshop.repository.ClienteRepository;
import com.Gerenciamento.Petshop.model.Cliente;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
    public Cliente cadastrarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
