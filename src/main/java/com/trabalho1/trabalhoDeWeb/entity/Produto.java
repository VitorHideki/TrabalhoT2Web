package com.trabalho1.trabalhoDeWeb.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "TB_PRODUTO")
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Produto {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PROD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "PROD_QUANTIDADEESTOQUE")
    private Long qtdEstoque;


    @Column(name = "PROD_IDADEPERMITIDA")
    private int idadePermitida;

    @Column(name = "PROD_PRECOCOMPRA")
    private double precoCompra;

    @Column(name = "PROD_PRECOVENDAFISICA")
    private double precoVendaFisica;

    @Column(name = "PROD_PRECOVENDAJURIDICA")
    private double precoVendaJuridica;

    @Column(name = "PROD_DESCRICAO")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Long qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getIdadePermitida() {
        return idadePermitida;
    }

    public void setIdadePermitida(int idadePermitida) {
        this.idadePermitida = idadePermitida;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVendaFisica() {
        return precoVendaFisica;
    }

    public void setPrecoVendaFisica(double precoVendaFisica) {
        this.precoVendaFisica = precoVendaFisica;
    }

    public double getPrecoVendaJuridica() {
        return precoVendaJuridica;
    }

    public void setPrecoVendaJuridica(double precoVendaJuridica) {
        this.precoVendaJuridica = precoVendaJuridica;
    }

    public Long getId(Long id) {
        return id;
    }

    public Produto(Long id){
        this.id = id;
    }

    public Produto() {

    }
}
