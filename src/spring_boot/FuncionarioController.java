package br.ifpe.jaboatao.padaria.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.ifpe.jaboatao.padaria.dao.FuncionarioDAO;
import br.ifpe.jaboatao.padaria.models.Funcionario;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    private final FuncionarioDAO funcionarioDAO;
    
    public FuncionarioController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }
    
    @GetMapping("/novo")
    public String formCadastro() {
        return "funcionario/cadFuncionario";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Funcionario funcionario, Model model) {
        funcionarioDAO.create(funcionario);
        model.addAttribute("mensagem", "Funcionário cadastrado com sucesso!");
        model.addAttribute("funcionario", funcionario);
        return "funcionario/resultCadFuncionario";
    }
    
    @GetMapping("/consultar")
    public String formConsulta() {
        return "funcionario/consultaFuncionario";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("funcionarios", funcionarioDAO.findByNome(nome));
        } else {
            model.addAttribute("funcionarios", funcionarioDAO.findAll());
        }
        return "funcionario/resultConsultaFuncionario";
    }
    
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable int id, Model model) {
        model.addAttribute("funcionario", funcionarioDAO.findById(id));
        return "funcionario/editFuncionario";
    }
    
    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Funcionario funcionario) {
        funcionarioDAO.update(funcionario);
        return "redirect:/funcionario/buscar";
    }
    
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        funcionarioDAO.delete(id);
        return "redirect:/funcionario/buscar";
    }
}