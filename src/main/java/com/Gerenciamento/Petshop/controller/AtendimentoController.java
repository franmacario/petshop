package com.Gerenciamento.Petshop.controller;


import ch.qos.logback.core.model.Model;
import com.Gerenciamento.Petshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Gerenciamento.Petshop.model.Atendimento;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AtendimentoRepository atendimentoRepository;




    @PostMapping("/registro-atendimento")
    public String registrarAtendimento(@ModelAttribute Atendimento atendimento) {
        atendimentoRepository.save(atendimento);

        return "redirect:/registro-atendimento";
    }
}
