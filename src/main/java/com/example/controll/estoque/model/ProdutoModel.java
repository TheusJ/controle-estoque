package com.example.controll.estoque.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    @Nonnull
    private String nome;

    @Column(length = 60)
    private String descricao;

    @Column(unique = true, nullable = false)
    @NotNull(message = "Não pode ser nulo")
    private String sku;

    @NotNull(message = "Não pode ser nulo")
    private Integer quantidade;




}
