package com.fiap.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_INVESTIMENTO")
public class Investimento {

    // Identificador unico do investimento no banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "investimento_seq")
    @SequenceGenerator(name = "investimento_seq", sequenceName = "SQ_INVESTIMENTO", allocationSize = 1)
    @Column(name = "ID_INVESTIMENTO")
    private Long id;

    // Dados financeiros do investimento acompanhado pela Fintech.
    @NotBlank
    @Column(name = "DESCRICAO", nullable = false, length = 120)
    private String descricao;

    @NotNull
    @Positive
    @Column(name = "VALOR", nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @NotNull
    @Column(name = "DATA_INVESTIMENTO", nullable = false)
    private LocalDate data;

    @NotBlank
    @Column(name = "CATEGORIA", nullable = false, length = 60)
    private String categoria;

    @NotNull
    @PositiveOrZero
    @Column(name = "RENDIMENTO", nullable = false, precision = 12, scale = 2)
    private BigDecimal rendimento = BigDecimal.ZERO;

    @NotNull
    @PositiveOrZero
    @Column(name = "TAXA_JUROS", nullable = false, precision = 8, scale = 4)
    private BigDecimal taxaJuros = BigDecimal.ZERO;

    @Column(name = "RESGATADO", nullable = false)
    private Boolean resgatado = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    public BigDecimal getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(BigDecimal taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public Boolean getResgatado() {
        return resgatado;
    }

    public void setResgatado(Boolean resgatado) {
        this.resgatado = resgatado;
    }
}

