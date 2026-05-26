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
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_DESPESA")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "despesa_seq")
    @SequenceGenerator(name = "despesa_seq", sequenceName = "SQ_DESPESA", allocationSize = 1)
    @Column(name = "ID_DESPESA")
    private Long id;

    @NotBlank
    @Column(name = "DESCRICAO", nullable = false, length = 120)
    private String descricao;

    @NotNull
    @Positive
    @Column(name = "VALOR", nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @NotNull
    @Column(name = "DATA_DESPESA", nullable = false)
    private LocalDate data;

    @NotBlank
    @Column(name = "CATEGORIA", nullable = false, length = 60)
    private String categoria;

    @NotBlank
    @Column(name = "FORMA_PAGAMENTO", nullable = false, length = 40)
    private String formaPagamento;

    @Column(name = "PAGA", nullable = false)
    private Boolean paga = false;

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

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Boolean getPaga() {
        return paga;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }
}

