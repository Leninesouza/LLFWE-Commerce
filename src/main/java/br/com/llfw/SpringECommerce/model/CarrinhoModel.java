package br.com.llfw.SpringECommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class CarrinhoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;
    private String nome;
    private String quantidade;
    private String preco;

    public CarrinhoModel() {

    }

    public CarrinhoModel( String nome, String quantidade, String preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
