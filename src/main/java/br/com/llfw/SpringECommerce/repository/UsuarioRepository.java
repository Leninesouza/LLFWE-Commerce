package br.com.llfw.SpringECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.llfw.SpringECommerce.model.UsuarioModel;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioModel, Integer>{
    UsuarioModel findbyEmailSenha(String email, String senha);
} 
