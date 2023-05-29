package com.vascobancoconta.vascobancocontaarti.models;

import java.util.List;

public class Conta {
    Integer id;
    String nome;
    String primeiroNome;
    String agencia;
    String numero;
    Integer digito;
    String numeroComDigito;
    String dataNascimento;
    String cpf;
    String profissao;
    Boolean elegivelCredito;
    Double saldo;
    List<Cheque> cheques;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public String getNumeroComDigito() {
        return numeroComDigito;
    }

    public void setNumeroComDigito(String numeroComDigito) {
        this.numeroComDigito = numeroComDigito;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Boolean getElegivelCredito() {
        return elegivelCredito;
    }

    public void setElegivelCredito(Boolean elegivelCredito) {
        this.elegivelCredito = elegivelCredito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Cheque> getCheques() {
        return cheques;
    }

    public void setCheques(List<Cheque> cheques) {
        this.cheques = cheques;
    }
}
