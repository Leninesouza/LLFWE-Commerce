package br.com.llfw.SpringECommerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class UsuarioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean admin;
    private String nome;
    private String sobrenome;
    private String email;
    private String celular;
    private String genero;
    private String estado;
    private String cidade;
    private String rua;
    private String senha;

    public UsuarioModel() {

    }

    public UsuarioModel( boolean admin, String nome, String sobrenome, String email, String celular, String genero,
                   String estado, String cidade, String rua, String senha) {
        this.admin = admin;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.celular = celular;
        this.genero = genero;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.senha = senha;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
