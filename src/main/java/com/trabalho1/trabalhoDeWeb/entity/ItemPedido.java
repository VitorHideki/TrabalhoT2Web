package com.trabalho1.trabalhoDeWeb.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "TB_ITEMPEDIDO")
@Inheritance(strategy = InheritanceType.JOINED)
@Builder

public class ItemPedido {

    private static final long seralVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PED_ID")
    private Pedido idPedido;

    @ManyToOne
    @JoinColumn(name = "PROD_ID")
    private Produto idProduto;

    @Column(name = "ITEMPEDIDO_QUANTIDADE")
    private Long quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public ItemPedido() {

    }
}
