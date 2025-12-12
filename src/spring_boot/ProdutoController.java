package br.ifpe.jaboatao.padaria.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.ifpe.jaboatao.padaria.dao.ProdutoDAO;
import br.ifpe.jaboatao.padaria.models.Produto;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    private final ProdutoDAO produtoDAO;
    
    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
    
    @GetMapping("/novo")
    public String formCadastro() {
        return "produto/cadProduto";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Produto produto, Model model) {
        produtoDAO.create(produto);
        model.addAttribute("mensagem", "Produto cadastrado com sucesso!");
        model.addAttribute("produto", produto);
        return "produto/resultCadProduto";
    }
    
    @GetMapping("/consultar")
    public String formConsulta() {
        return "produto/consultaProduto";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("produtos", produtoDAO.findByNome(nome));
        } else {
            model.addAttribute("produtos", produtoDAO.findAll());
        }
        return "produto/resultConsultaProduto";
    }
    
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable int id, Model model) {
        model.addAttribute("produto", produtoDAO.findById(id));
        return "produto/editProduto";
    }
    
    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Produto produto) {
        produtoDAO.update(produto);
        return "redirect:/produto/buscar";
    }
    
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        produtoDAO.delete(id);
        return "redirect:/produto/buscar";
    }
}