package com.gabriel.api_produdos.model;

import jakarta.persistence.*;

@Entity //Diz ao spring que é uma tabela
@Table(name = "produto_spring") //Opcional para dar um nome customizado à tabela
public class Produto {
    @Id //Diz que essa é a chave primária
    @GeneratedValue(strategy =GenerationType.IDENTITY) //Auto incrementen na chave
    private Integer id;

    @Column(nullable = false)
    private String nome;
    private Double preco;

    public Produto() {}

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
