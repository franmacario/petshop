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
}
