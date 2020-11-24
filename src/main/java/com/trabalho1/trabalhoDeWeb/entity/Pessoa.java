package com.trabalho1.trabalhoDeWeb.entity;

import com.trabalho1.trabalhoDeWeb.enums.Situacao;
import com.trabalho1.trabalhoDeWeb.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.tomcat.jni.Local;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "TB_PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PES_TIPO_JPA")
@Builder
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PES_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "PES_IDRESPONSAVEL")
    private Long idResponsavel;

    @Enumerated(EnumType.STRING)
    @Column(name = "PES_TIPO")
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "PES_SITUACAO")
    private Situacao situacao;

    @Column(name = "PES_NOME")
    private String nome;

    @Column(name = "PES_APELIDO")
    private String apelido;

    @Column(name = "PES_DATADENASCIMENTO")
    private LocalDate dataDeNascimento;


    public Pessoa(Long id){
        this.id = id;
    }

    public Pessoa() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Long getId(Long id) {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}


