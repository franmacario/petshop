package com.Gerenciamento.Petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Gerenciamento.Petshop.model.Atendimento;

import com.Gerenciamento.Petshop.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
    private AtendimentoRepository atendimentoRepository;

    public List<Atendimento> listarAtendimento(){
        return atendimentoRepository.findAll();
    }

    public Atendimento cadastrarAtendimento(Atendimento atendimento){
        return atendimentoRepository.save(atendimento);
    }
    public Atendimento buscarAtendimentoPorId(Long id) {
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
    }
}
