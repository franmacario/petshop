package com.Gerenciamento.Petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Gerenciamento.Petshop.model.Servico;
import com.Gerenciamento.Petshop.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarServicos(){
        return servicoRepository.findAll();
    }
    public Servico cadastrarServico(Servico servico){
        return servicoRepository.save(servico);
    }
    public Servico adicionarServico(String nome, double preco) {
        Servico servico = new Servico(nome, preco);
        return servicoRepository.save(servico);
    }

    public void adicionarServicosDisponiveis() {
        adicionarServico("Banho", 30.0);
        adicionarServico("Hidratação", 40.0);
        adicionarServico("Tosa Higiênica", 25.0);
        adicionarServico("Escovação de Dentes", 15.0);
        adicionarServico("Limpeza de Ouvido", 20.0);
        adicionarServico("Corte de Unhas", 15.0);
        adicionarServico("Vacina", 50.0);
    }
    
}
