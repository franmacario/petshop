package com.Gerenciamento.Petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Gerenciamento.Petshop.model.Funcionario;
import com.Gerenciamento.Petshop.service.FuncionarioService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
@Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionario();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public String cadastrarFuncionario(@RequestParam("nome") String nome,
                                       @RequestParam("cargo") String cargo,
                                       RedirectAttributes redirectAttributes) {
        Funcionario funcionario = new Funcionario(nome, cargo);
        funcionarioService.cadastrarFuncionario(funcionario);


        redirectAttributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso e atendimento concluído!");
        return "redirect:/index.html";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

}
