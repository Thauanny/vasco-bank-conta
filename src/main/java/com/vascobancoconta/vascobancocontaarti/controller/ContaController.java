package com.vascobancoconta.vascobancocontaarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vascobancoconta.vascobancocontaarti.models.Conta;
import com.vascobancoconta.vascobancocontaarti.service.ContaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/contaCorrente")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @PostMapping("/{idUser}")
    public ResponseEntity<?> cadastrarConta(@PathVariable Integer idUser, @RequestBody Conta conta) {
        try {
            return ResponseEntity.ok(contaService.cadastrarConta(conta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @PutMapping("/{idUser}")
    public ResponseEntity<?> atualizarConta(@PathVariable Integer idUser, @RequestBody Conta conta) {
        try {
            return ResponseEntity.ok(contaService.atualizarConta(conta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @GetMapping("/{idConta}")
    public ResponseEntity<?> conta(@PathVariable Integer idConta) {
        try {
            // chamada service

            return ResponseEntity.ok(contaService.conta(idConta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @DeleteMapping("/{idConta}")
    public ResponseEntity<?> deleteConta(@PathVariable Integer idConta) {
        try {
            contaService.deleteConta(idConta);
            return ResponseEntity.ok("{\"message\": \"Conta excluida\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @GetMapping("/saldo/{idConta}")
    public ResponseEntity<?> saldo(@PathVariable Integer idConta) {
        try {
            return ResponseEntity.ok("{\"valor\":" + contaService.saldo(idConta) + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @PutMapping("/saldo/{idConta}")
    public ResponseEntity<?> saldo(@PathVariable Integer idConta, @RequestBody double saldo) {
        try {

            return ResponseEntity.ok("{\"valor\":" + contaService.atualizarSaldo(idConta, saldo).getSaldo() + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

}
