package com.trabalho1.trabalhoDeWeb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PESSOA_JURIDICA")
@PrimaryKeyJoinColumn(name = "PES_ID")
@DiscriminatorValue("JURIDICA")
public class PessoaJuridica extends Pessoa{

    @Column(name = "PJ_CNPJ")
    private String cnpj;
}
