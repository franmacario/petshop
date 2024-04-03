package com.Gerenciamento.Petshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos(){
        List<Servico> servicos =servicoService.listarServicos();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Servico> cadastrarServico(@RequestBody Servico servico){
        Servico novoServico= servicoService.cadastrarServico(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.CREATED);
    }
    @PostMapping("/adicionar")
    public ResponseEntity<Servico> adicionarServico(@RequestBody Servico servico) {
        Servico novoServico = servicoService.cadastrarServico(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }
    
}
