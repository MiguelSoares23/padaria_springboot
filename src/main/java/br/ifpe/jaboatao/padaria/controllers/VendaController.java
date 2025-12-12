package br.ifpe.jaboatao.padaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.ifpe.jaboatao.padaria.dao.VendaDAO;
import br.ifpe.jaboatao.padaria.dao.ClienteDAO;
import br.ifpe.jaboatao.padaria.dao.FuncionarioDAO;
import br.ifpe.jaboatao.padaria.models.Venda;

@Controller
@RequestMapping("/venda")
public class VendaController {
    
    private final VendaDAO vendaDAO;
    private final ClienteDAO clienteDAO;
    private final FuncionarioDAO funcionarioDAO;
    
    public VendaController(VendaDAO vendaDAO, ClienteDAO clienteDAO, FuncionarioDAO funcionarioDAO) {
        this.vendaDAO = vendaDAO;
        this.clienteDAO = clienteDAO;
        this.funcionarioDAO = funcionarioDAO;
    }
    
    @GetMapping("/novo")
    public String formCadastro(Model model) {
        model.addAttribute("clientes", clienteDAO.findAll());
        model.addAttribute("funcionarios", funcionarioDAO.findAll());
        return "venda/cadVenda";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Venda venda, Model model) {
        vendaDAO.create(venda);
        model.addAttribute("mensagem", "Venda cadastrada com sucesso!");
        model.addAttribute("venda", venda);
        return "venda/resultCadVenda";
    }
    
    @GetMapping("/consultar")
    public String formConsulta() {
        return "venda/consultaVenda";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam(required = false) Integer idCliente, Model model) {
        if (idCliente != null) {
            model.addAttribute("vendas", vendaDAO.findByCliente(idCliente));
        } else {
            model.addAttribute("vendas", vendaDAO.findAll());
        }
        return "venda/resultConsultaVenda";
    }
    
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable int id, Model model) {
        model.addAttribute("venda", vendaDAO.findById(id));
        model.addAttribute("clientes", clienteDAO.findAll());
        model.addAttribute("funcionarios", funcionarioDAO.findAll());
        return "venda/editVenda";
    }
    
    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Venda venda) {
        vendaDAO.update(venda);
        return "redirect:/venda/buscar";
    }
    
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        vendaDAO.delete(id);
        return "redirect:/venda/buscar";
    }
}