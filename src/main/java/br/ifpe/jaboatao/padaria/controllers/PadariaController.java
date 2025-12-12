package br.ifpe.jaboatao.padaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ifpe.jaboatao.padaria.dao.PadariaDAO;
import br.ifpe.jaboatao.padaria.models.Padaria;

@Controller
@RequestMapping("/padaria")
public class PadariaController {
    
    private final PadariaDAO padariaDAO;
    
    public PadariaController(PadariaDAO padariaDAO) {
        this.padariaDAO = padariaDAO;
    }
    
    @GetMapping("/novo")
    public String formCadastro() {
        return "padaria/cadPadaria";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Padaria padaria, Model model) {
        padariaDAO.create(padaria);
        model.addAttribute("mensagem", "Padaria cadastrada com sucesso!");
        model.addAttribute("padaria", padaria);
        return "padaria/resultCadPadaria";
    }
    
    @GetMapping("/consultar")
    public String formConsulta() {
        return "padaria/consultaPadaria";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("padarias", padariaDAO.findByNome(nome));
        } else {
            model.addAttribute("padarias", padariaDAO.findAll());
        }
        return "padaria/resultConsultaPadaria";
    }
    
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable int id, Model model) {
        model.addAttribute("padaria", padariaDAO.findById(id));
        return "padaria/editPadaria";
    }
    
    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Padaria padaria) {
        padariaDAO.update(padaria);
        return "redirect:/padaria/buscar";
    }
    
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        padariaDAO.delete(id);
        return "redirect:/padaria/buscar";
    }
}
