package br.com.llfw.SpringECommerce.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProdutosModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String marca;
    private String modelo;
    private String estoque;
    private String descricao;
    private String valor;



    public ProdutosModel() {

    }

    public ProdutosModel(String nome, String marca, String modelo, String descricao, String valor, String estoque) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public void setValor(String valor) {
        this.valor = valor;
    }


    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getEstoque() {
        return estoque;
    }

    public String getValor() {
        return valor;
    }
}
