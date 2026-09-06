package com.example.controll.estoque.model;

import com.example.controll.estoque.enums.TipoCargo;
import com.example.controll.estoque.enums.TipoSetor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 130)
    private String nome;

    @Column(length = 3)
    private int idade;


    @Email
    @NotNull(message = "O email é obrigatório")
    @Column(unique = true)
    private String email;

    @CPF
    @NotNull(message = "O cpf é obrigatório")
    @Column(unique = true, nullable = false)
    private String cpf;

    @NotNull(message = "O cargo é obrigatório")
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private TipoCargo cargo;

    @NotNull(message = "O setor é obrigatório")
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private TipoSetor setor;
    private BigDecimal salario;

    @CreationTimestamp
    private LocalDate dataContratacao;


    @Override
    public boolean equals(Object object) {
        if(object == null) return false;
        if(this == object) return true;
        if(this.getClass() != object.getClass()) return false;
        FuncionarioModel outroFuncionario = (FuncionarioModel) object;
        return Objects.equals(this.cpf, outroFuncionario.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public TipoCargo getCargo() {
        return cargo;
    }

    public TipoSetor getSetor() {
        return setor;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCargo(TipoCargo cargo) {
        this.cargo = cargo;
    }

    public void setSetor(TipoSetor setor) {
        this.setor = setor;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
