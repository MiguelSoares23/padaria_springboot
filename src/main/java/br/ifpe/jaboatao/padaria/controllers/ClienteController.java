package br.ifpe.jaboatao.padaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ifpe.jaboatao.padaria.dao.ClienteDAO;
import br.ifpe.jaboatao.padaria.models.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    private final ClienteDAO clienteDAO;
    
    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    @GetMapping("/novo")
    public String formCadastro() {
        return "cliente/cadCliente";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Cliente cliente, Model model) {
        clienteDAO.create(cliente);
        model.addAttribute("mensagem", "Cliente cadastrado com sucesso!");
        model.addAttribute("cliente", cliente);
        return "cliente/resultCadCliente";
    }
    
    @GetMapping("/consultar")
    public String formConsulta() {
        return "cliente/consultaCliente";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("clientes", clienteDAO.findByNome(nome));
        } else {
            model.addAttribute("clientes", clienteDAO.findAll());
        }
        return "cliente/resultConsultaCliente";
    }
    
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteDAO.findById(id));
        return "cliente/editCliente";
    }
    
    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Cliente cliente) {
        clienteDAO.update(cliente);
        return "redirect:/cliente/buscar";
    }
    
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        clienteDAO.delete(id);
        return "redirect:/cliente/buscar";
    }
}