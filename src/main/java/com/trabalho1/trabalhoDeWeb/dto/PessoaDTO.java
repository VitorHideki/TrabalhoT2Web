package com.trabalho1.trabalhoDeWeb.dto;

import com.trabalho1.trabalhoDeWeb.entity.PessoaFisica;
import com.trabalho1.trabalhoDeWeb.entity.PessoaJuridica;
import com.trabalho1.trabalhoDeWeb.enums.Situacao;
import com.trabalho1.trabalhoDeWeb.enums.Tipo;
import com.trabalho1.trabalhoDeWeb.repository.PessoaFisicaRepository;
import com.trabalho1.trabalhoDeWeb.repository.PessoaJuridicaRepository;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import org.apache.tomcat.jni.Local;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class PessoaDTO {
    private Long id;
    private Long idResponsavel;
    private Tipo tipo;
    private Situacao situacao;
    private String nome;
    private String apelido;
    private String cpf;
    private String rg;
    private String cnpj;
    private Pessoa pessoa;
    private LocalDate dataDeNascimento;

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    PessoaFisicaRepository pessoaFisicaRepository;
    PessoaJuridicaRepository pessoaJuridicaRepository;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCpnj(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaDTO(Long id,Long idResponsavel,Tipo tipo,Situacao situacao,String nome, String apelido,String cpf, String rg, String cnpj){
        this.id = id;
        this.idResponsavel = idResponsavel;
        this.tipo = tipo;
        this.situacao = situacao;
        this.nome = nome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.rg = rg;
        this.cnpj = cnpj;

    }



    public Long getId() {
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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaJuridica gerarPessoaJuridica(){
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setId(this.id);
        pessoaJuridica.setIdResponsavel(this.idResponsavel);
        pessoaJuridica.setTipo(this.tipo);
        pessoaJuridica.setSituacao(this.situacao);
        pessoaJuridica.setNome(this.nome);
        pessoaJuridica.setApelido(this.apelido);
        pessoaJuridica.setCnpj(this.cnpj);
        pessoaJuridica.setDataDeNascimento(this.dataDeNascimento);
        return pessoaJuridica;
    }
    public PessoaFisica gerarPessoaFisica(){
        PessoaFisica pessoa= new PessoaFisica();
        pessoa.setId(this.id);
        pessoa.setIdResponsavel(this.idResponsavel);
        pessoa.setTipo(this.tipo);
        pessoa.setSituacao(this.situacao);
       pessoa.setNome(this.nome);
        pessoa.setApelido(this.apelido);
        pessoa.setCpf(this.cpf);
        pessoa.setRg(this.rg);
        pessoa.setDataDeNascimento(this.dataDeNascimento);
        return pessoa;
    }
}
