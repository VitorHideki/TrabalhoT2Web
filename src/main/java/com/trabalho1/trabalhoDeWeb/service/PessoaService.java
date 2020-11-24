package com.trabalho1.trabalhoDeWeb.service;

import com.trabalho1.trabalhoDeWeb.dto.PessoaDTO;
import com.trabalho1.trabalhoDeWeb.enums.Situacao;
import com.trabalho1.trabalhoDeWeb.enums.Tipo;
import com.trabalho1.trabalhoDeWeb.repository.PessoaFisicaRepository;
import com.trabalho1.trabalhoDeWeb.repository.PessoaJuridicaRepository;
import com.trabalho1.trabalhoDeWeb.repository.PessoaRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PessoaService {
    private ZoneId ZONEID = ZoneId.of("America/Sao_Paulo");
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRespository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRespository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private LoginService loginService;

    public Pessoa buscar(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        return pessoaOptional.orElse(null);
    }


    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    //
    public Object buscarPorId(Long id) {
        Pessoa Pessoa = pessoaRepository.findById(id).get();
        return Pessoa;
    }


    public Pessoa salvar(PessoaDTO pessoaDto) {
        if (Tipo.FISICA.equals(pessoaDto.getTipo())) {
            return pessoaFisicaRespository.save(pessoaDto.gerarPessoaFisica());
        } else {
            return pessoaJuridicaRespository.save(pessoaDto.gerarPessoaJuridica());

        }
    }

    public int calcularIdade(PessoaDTO pessoaDTO) {
        LocalDate dataHoje = LocalDate.now();

        LocalDate pessoaDataDeNascimento = LocalDate.of(pessoaDTO.getDataDeNascimento().getYear(), pessoaDTO.getDataDeNascimento().getMonth(), pessoaDTO.getDataDeNascimento().getDayOfMonth());
        LocalDate idadePermitidaData = LocalDate.of(dataHoje.getYear(), dataHoje.getMonth(), dataHoje.getDayOfMonth());
        Period idade = Period.between(pessoaDataDeNascimento, idadePermitidaData);
        return idade.getYears();
    }

    public List<Pessoa> buscaStream(@RequestParam(name = "idResponsavel", required = false) Long idResponsavel, @RequestParam
            (name = "nomeDoResponsavel", required = false) String nomeDoResponsavel, @RequestParam(name = "tipo", required = false)
                                            Tipo tipo, @RequestParam(name = "situacao", required = false) Situacao situacao) throws Exception {
        List<Pessoa> busca;
        busca = pessoaRepository.findAll().stream()
                .filter(pessoa -> {
                            if (situacao != null) {
                                return pessoa.getSituacao().equals(situacao);
                            } else {
                                return true;
                            }
                        }
                ).filter(pessoa -> {
                    if (Objects.nonNull( pessoa.getIdResponsavel())) {
                        if(idResponsavel != null) {
                            return pessoa.getIdResponsavel().equals(idResponsavel);
                        } return true;
                    }else {
                        return false;
                    }
                }).filter(pessoa -> {
                    if (tipo != null && Objects.nonNull( pessoa.getIdResponsavel())) {
                        return pessoa.getTipo().equals(tipo);
                    }else {
                    return true;
                    }}).filter(pessoa -> {
                    if (nomeDoResponsavel != null) {
                        return pessoa.getNome().equals(nomeDoResponsavel);
                    } else{
                        return true;
                    }
                }).collect(Collectors.toList());

        return busca;
    }


    public Pessoa alterar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa salvarPessoaFisicaMenorDeIdade(PessoaDTO pessoaDto) throws Exception {
        Optional<Pessoa> pessoaResponsavel = pessoaRepository.findById(pessoaDto.getIdResponsavel());
        if (pessoaResponsavel.isEmpty()) {
            throw new Exception();
        } else {
            return pessoaFisicaRespository.save(pessoaDto.gerarPessoaFisica());
        }
    }
}
