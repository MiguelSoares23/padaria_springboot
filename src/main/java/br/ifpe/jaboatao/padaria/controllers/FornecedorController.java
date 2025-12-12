package br.ifpe.jaboatao.padaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ifpe.jaboatao.padaria.dao.FornecedorDAO;
import br.ifpe.jaboatao.padaria.models.Fornecedor;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
    
    private final FornecedorDAO fornecedorDAO;
    
    public FornecedorController(FornecedorDAO fornecedorDAO) {
        this.fornecedorDAO = fornecedorDAO;
    }
    
    @GetMapping("/novo")
    public String formCadastro() {
        return "fornecedor/cadFornecedor";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Fornecedor fornecedor, Model model) {
        fornecedorDAO.create(fornecedor);
        model.addAttribute("mensagem", "Fornecedor cadastrado com sucesso!");
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor/resultCadFornecedor";
    }
    
    @GetMapping("/consultar")
    public String formConsulta() {
        return "fornecedor/consultaFornecedor";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("fornecedores", fornecedorDAO.findByNome(nome));
        } else {
            model.addAttribute("fornecedores", fornecedorDAO.findAll());
        }
        return "fornecedor/resultConsultaFornecedor";
    }
    
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable int id, Model model) {
        model.addAttribute("fornecedor", fornecedorDAO.findById(id));
        return "fornecedor/editFornecedor";
    }
    
    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Fornecedor fornecedor) {
        fornecedorDAO.update(fornecedor);
        return "redirect:/fornecedor/buscar";
    }
    
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        fornecedorDAO.delete(id);
        return "redirect:/fornecedor/buscar";
    }
}
