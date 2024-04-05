package com.Gerenciamento.Petshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gerenciamento.Petshop.model.Servico;
import com.Gerenciamento.Petshop.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private ServicoService servicoService;

    @GetMapping("/servicos-disponiveis")
    public String listarServicos(Model model) {
        List<Servico> servicosDisponiveis = new ArrayList<>();
        servicosDisponiveis.add(new Servico(1L, "Banho", 30.0));
        servicosDisponiveis.add(new Servico(2L, "Hidratação", 40.0));
        servicosDisponiveis.add(new Servico(3L, "Tosa Higiênica", 25.0));
        servicosDisponiveis.add(new Servico(4L, "Escovação de Dentes", 15.0));
        servicosDisponiveis.add(new Servico(5L, "Limpeza de Ouvido", 20.0));
        servicosDisponiveis.add(new Servico(6L, "Corte de Unhas", 15.0));
        servicosDisponiveis.add(new Servico(7L, "Vacina", 50.0));

        model.addAttribute("servicos", servicosDisponiveis);
        return "servicos_disponiveis";
    }


    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos(){
        List<Servico> servicos =servicoService.listarServicos();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Servico> adicionarServico(@RequestBody Servico servico) {
        Servico novoServico = servicoService.cadastrarServico(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }
    
}
