package br.com.llfw.SpringECommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.llfw.SpringECommerce.model.UsuarioModel;
import br.com.llfw.SpringECommerce.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlller {
    @Autowired
    private UsuarioRepository usuarioRepository;

    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuarios", new UsuarioModel());
        return "produtos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute UsuarioModel novoUsuario) {
        usuarioRepository.save(novoUsuario);
        return "redirect:/usuarios";
    }

    @PutMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        UsuarioModel usuario = usuarioRepository.findById(id).orElseThrow();
        model.addAttribute("usuario", usuario);
        return "usuarios/form";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        //produtoRepository.deleteById(id);
        return "redirect:/usuarios";
    }



    // LOGIN

    @GetMapping
    public String loginForm(@RequestParam(required = false) String erro, Model model) {
        if ("1".equals(erro)) {
            model.addAttribute("erro", "Email ou senha inválidos.");
        }
        return "usuario/login";  // View: templates/usuario/login.html
    }

    // Processa login
    @PostMapping
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {
        UsuarioModel usuario = usuarioRepository.findbyEmailSenha(email, password);
        
        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/index";  // Ou outra rota
        } else {
            return "redirect:/login?erro=1";
        }
    }
}
