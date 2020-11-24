package com.trabalho1.trabalhoDeWeb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PESSOA_FISICA")
@PrimaryKeyJoinColumn(name = "PES_ID")
@DiscriminatorValue("FISICA")
public class PessoaFisica extends Pessoa {

    @Column(name = "PF_RG")
    private String rg;

    @Column(name = "PF_CPF")
    private String cpf;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
