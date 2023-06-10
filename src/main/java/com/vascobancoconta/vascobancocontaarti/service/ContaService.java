package com.vascobancoconta.vascobancocontaarti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vascobancoconta.vascobancocontaarti.models.Conta;
import com.vascobancoconta.vascobancocontaarti.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta cadastrarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta atualizarConta(Conta conta) {
        Conta _conta = contaRepository.findById(conta.getId()).get();
        _conta.setAgencia(conta.getAgencia());
        _conta.setCpf(conta.getCpf());
        _conta.setDigito(conta.getDigito());
        _conta.setNome(conta.getNome());
        _conta.setNumero(conta.getNumero());
        _conta.setNumeroComDigito(conta.getNumeroComDigito());
        _conta.setPrimeiroNome(conta.getPrimeiroNome());
        _conta.setProfissao(conta.getProfissao());
        _conta.setSaldo(conta.getSaldo());
        return contaRepository.save(_conta);
    }

    public Conta retornarConta(Integer userId) {
        return contaRepository.retornarConta(userId);
    }

    public Conta retornarContaChavePix(String chave, Integer idConta) {
        return contaRepository.retornarContaChavePix(chave, idConta);
    }

    public Conta cadastrarChavePix(String chave, Integer idConta) {
        Conta conta = retornarConta(idConta);
        conta.setChavePix(chave);
        return contaRepository.save(conta);
    }

    public void deleteConta(Integer idConta) {
        contaRepository.deleteById(idConta);
    }

    public double saldo(Integer idConta) {
        return contaRepository.findById(idConta).get().getSaldo();
    }

    public Conta atualizarSaldo(Integer idConta, double saldo) {

        Conta _conta = contaRepository.findById(idConta).get();
        _conta.setSaldo(saldo);
        return contaRepository.save(_conta);
    }

}
