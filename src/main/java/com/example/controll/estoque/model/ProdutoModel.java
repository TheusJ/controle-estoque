package com.example.controll.estoque.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    @NotNull(message = "Nome do produto não pode ser nulo")
    private String nome;

    @Column(length = 60)
    private String descricao;


    @NotNull(message = "O preço venda não pode ser nulo")
    private BigDecimal precoCusto;

    @NotNull(message = "O preço venda não pode ser nulo")
    private BigDecimal precoVenda;

    private BigDecimal margemLucro;

    @CreationTimestamp
    private LocalDateTime dataEntradaEstoque;

    @Column(unique = true, nullable = false, length = 90)
    @NotNull(message = "Sku do produto não pode ser nulo")
    @Pattern(regexp = "^[A-Za-z]{4}-\\d{3}-[A-Za-z0-9]{1,9}$", message = "Para cadastrar um produto, é necessário ter um SKU do Produto padrão.")
    private String sku;

    @NotNull(message = "Quantidade do produto não pode ser nulo")
    private Integer quantidade;

    @Override
    public boolean equals(Object object) {
        if(object == null) return false;
        if(this == object) return true;
        if(this.getClass() != object.getClass()) return false;
        ProdutoModel produtoSku = (ProdutoModel) object;
        return Objects.equals(this.sku, produtoSku.getSku());
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }
}
