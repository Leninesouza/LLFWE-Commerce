package br.com.llfw.SpringECommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.llfw.SpringECommerce.model.CarrinhoModel;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @GetMapping
    public String exibirCarrinho(HttpSession session, Model model) {
        // Recupera a lista de carrinho da sessão
        List<CarrinhoModel> carrinhoList = (List<CarrinhoModel>) session.getAttribute("carrinhoList");
        if (carrinhoList == null) {
            carrinhoList = new ArrayList<>();
        }
        model.addAttribute("carrinhoList", carrinhoList);  // Adiciona a lista ao modelo para ser exibida na view
        return "carrinho/carrinho";  // Nome da página Thymeleaf (HTML)
    }

    @GetMapping("/limpar")
    public String limparCarrinho(HttpSession session) {
        // Limpa o carrinho na sessão
        session.removeAttribute("carrinhoList");
        return "redirect:/carrinho";  // Redireciona para a lista de carrinho
    }

    @GetMapping("/remover/{id}")
    public String removerProduto(@PathVariable("id") int id, HttpSession session) {
        // Recupera a lista de carrinho da sessão
        List<CarrinhoModel> carrinhoList = (List<CarrinhoModel>) session.getAttribute("carrinhoList");
        if (carrinhoList != null) {
            carrinhoList.removeIf(item -> item.getIdProduto() == id);  // Remove o item pelo ID
        }
        return "redirect:/carrinho";  // Redireciona para a lista de carrinho
    }

    @GetMapping("/adicionar")
    public String adicionarProduto(@RequestParam("id") int id,
                                   @RequestParam("nome") String nome,
                                   @RequestParam("valor") double valor,
                                   HttpSession session) {
        // Recupera a lista de carrinho da sessão
        List<CarrinhoModel> carrinhoList = (List<CarrinhoModel>) session.getAttribute("carrinhoList");
        if (carrinhoList == null) {
            carrinhoList = new ArrayList<>();
            session.setAttribute("carrinhoList", carrinhoList);  // Cria um novo carrinho se não existir
        }

        // Verifica se o produto já está no carrinho
        CarrinhoModel itemExistente = carrinhoList.stream()
                .filter(item -> item.getIdProduto() == id)
                .findFirst()
                .orElse(null);

        if (itemExistente != null) {
            // Se o produto já estiver no carrinho, aumenta a quantidade
            int novaQuantidade = Integer.parseInt(itemExistente.getQuantidade()) + 1;
            itemExistente.setQuantidade(String.valueOf(novaQuantidade));
        } else {
            // Se o produto não estiver no carrinho, adiciona um novo item
            CarrinhoModel novoItem = new CarrinhoModel();
            novoItem.setIdProduto(id);
            novoItem.setNome(nome);
            novoItem.setPreco(String.valueOf(valor));
            novoItem.setQuantidade("1");
            carrinhoList.add(novoItem);
        }

        return "redirect:/carrinho";  // Redireciona para a lista de carrinho
    }
}
