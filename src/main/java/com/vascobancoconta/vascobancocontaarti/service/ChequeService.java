package com.vascobancoconta.vascobancocontaarti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vascobancoconta.vascobancocontaarti.models.Cheque;
import com.vascobancoconta.vascobancocontaarti.repository.ChequeRepository;

@Service
public class ChequeService {
    @Autowired
    private ChequeRepository ChequeRepository;

    public Cheque cadastrarCheque(Cheque cheque) {
        return ChequeRepository.save(cheque);
    }

    public List<Cheque> retornarCheques(Integer idCheque) {
        // return List.of(new Cheque());
        return ChequeRepository.cheques(idCheque);
    }

    public Cheque retornarCheque(Integer idCheque) {
        return ChequeRepository.findById(idCheque).get();
    }

    public double limite(Integer idCheque) {
        return ChequeRepository.findById(idCheque).get().getLimite();
    }

    public Cheque atualizarlimite(Cheque cheque, double valor) {
        cheque.setLimite(valor);
        return cadastrarCheque(cheque);
    }

    public double juros(Cheque cheque) {
        return ChequeRepository.findById(cheque.getId()).get().getJuros();
    }

    public Cheque atualizarJuros(Cheque cheque, double valor) {
        cheque.setJuros(valor);
        return cadastrarCheque(cheque);
    }
}
