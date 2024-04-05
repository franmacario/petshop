package com.Gerenciamento.Petshop.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Gerenciamento.Petshop.model.Cliente;
import com.Gerenciamento.Petshop.service.ClienteService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public String cadastrarCliente(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefone") String telefone,
                                   @RequestParam("endereco") String endereco,
                                   RedirectAttributes redirectAttributes) {
        Cliente cliente = new Cliente(nome, email, telefone, endereco);
        clienteService.cadastrarCliente(cliente);

        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
        return "cadastro_cliente.html";
    }


}
