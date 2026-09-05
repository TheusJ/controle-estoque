package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(length = 130)
    private String nome;

    @Column(length = 3)
    private int idade;


    @Email
    @NotBlank
    private String email;

    @CPF
    @NotBlank
    private String cpf;

    @NotBlank
    private String cargo;

    @NotBlank
    private String setor;
    private BigDecimal salario;

    @CreationTimestamp
    private LocalDate dataContratacao;

    public UUID getId() {
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

    public String getCargo() {
        return cargo;
    }

    public String getSetor() {
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
}
