package br.com.llfw.SpringECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.llfw.SpringECommerce.model.ProdutosModel;
import br.com.llfw.SpringECommerce.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produtos/listar";  // Retorna o nome da view Thymeleaf (HTML)
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new ProdutosModel());
        return "produtos/form";  // Retorna a view para criar um novo produto
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ProdutosModel produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos";  // Redireciona para a lista de produtos após salvar
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        ProdutosModel produto = produtoRepository.findById(id).orElseThrow();
        model.addAttribute("produto", produto);
        return "produtos/form";  // Retorna a view para editar um produto
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        produtoRepository.deleteById(id);
        return "redirect:/produtos";  // Redireciona para a lista de produtos após excluir
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(@ModelAttribute ProdutosModel produto) {
        produtoRepository.save(produto);
        return "redirect:/administrador"; // Redireciona após cadastro
    }
}