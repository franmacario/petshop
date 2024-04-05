package com.Gerenciamento.Petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Gerenciamento.Petshop.model.Funcionario;
import com.Gerenciamento.Petshop.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    
    public List<Funcionario> listarFuncionario(){
        return funcionarioRepository.findAll();
    }
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }
}
