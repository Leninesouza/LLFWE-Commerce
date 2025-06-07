package br.com.llfw.SpringECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.llfw.SpringECommerce.model.ProdutosModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutosModel, Integer> {
} 
