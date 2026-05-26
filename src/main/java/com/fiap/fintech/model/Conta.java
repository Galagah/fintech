package com.fiap.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_CONTA")
public class Conta {

    // Identificador unico da conta no banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_seq")
    @SequenceGenerator(name = "conta_seq", sequenceName = "SQ_CONTA", allocationSize = 1)
    @Column(name = "ID_CONTA")
    private Long id;

    // Dados bancarios usados para controlar saldo e status da conta.
    @NotBlank
    @Column(name = "NUMERO_CONTA", nullable = false, unique = true, length = 30)
    private String numeroConta;

    @NotBlank
    @Column(name = "TITULAR", nullable = false, length = 120)
    private String titular;

    @NotNull
    @PositiveOrZero
    @Column(name = "SALDO", nullable = false, precision = 12, scale = 2)
    private BigDecimal saldo = BigDecimal.ZERO;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 20)
    private TipoConta tipo = TipoConta.CORRENTE;

    @Column(name = "ATIVA", nullable = false)
    private Boolean ativa = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }
}

