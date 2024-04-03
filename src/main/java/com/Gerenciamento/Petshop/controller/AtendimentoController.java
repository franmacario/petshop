package com.Gerenciamento.Petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gerenciamento.Petshop.model.Atendimento;
import com.Gerenciamento.Petshop.service.AtendimentoService;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {
    
    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<List<Atendimento>> listarAtendimentos() {
        List<Atendimento> atendimentos = atendimentoService.listarAtendimento();
        return new ResponseEntity<>(atendimentos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Atendimento> cadastrarAtendimento(@RequestBody Atendimento atendimento) {
        Atendimento novoAtendimento = atendimentoService.cadastrarAtendimento(atendimento);
        return new ResponseEntity<>(novoAtendimento, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> buscarAtendimentoPorId(@PathVariable Long id) {
        Atendimento atendimento = atendimentoService.buscarAtendimentoPorId(id);
        if (atendimento != null) {
            return ResponseEntity.ok(atendimento); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
}
