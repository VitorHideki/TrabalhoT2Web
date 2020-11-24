package com.trabalho1.trabalhoDeWeb.entity;

import com.trabalho1.trabalhoDeWeb.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Pedido {

        private static final long serialVersionUID = 1L;
        @Id
        @Column(name = "PED_ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "PES_ID", nullable = false)
        private Pessoa idPessoa;

        @Enumerated(EnumType.STRING)
        @Column(name = "PED_STATUS")
        private Status status;

        @Column(name = "PED_DATACOMPRA")
        private Date dataCompra;


        @Column(name = "PED_DATAENTREGA")
        private Date dataEntrega;

        @Column(name = "PED_PERCENTUALDEDESCONTO")
        private String percentualDeDesconto;

    public Pedido(Long id){
        this.id = id;
    }

    public Pedido() {

    }

    public Long getIdPedido() {
        return id;
    }

    public void setIdPedido(Long id) {
        this.id = id;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public void setPercentualDeDesconto(String percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
    }
}

