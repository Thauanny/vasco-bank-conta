package com.vascobancoconta.vascobancocontaarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vascobancoconta.vascobancocontaarti.models.Conta;
import com.vascobancoconta.vascobancocontaarti.models.DTO.ChaveDTO;
import com.vascobancoconta.vascobancocontaarti.models.DTO.SaldoDTO;
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
            // verificar se existe user
            if (contaService.retornarConta(idUser) != null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"message\": \"usuario ja possui conta cadastrada\"}");

            conta.setIdUser(idUser);
            return ResponseEntity.ok(contaService.cadastrarConta(conta));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @PutMapping("/{idConta}")
    public ResponseEntity<?> atualizarConta(@PathVariable Integer idConta, @RequestBody Conta conta) {
        try {
            if (contaService.retornarConta(idConta) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Conta nao encontrado\"}");
            return ResponseEntity.ok(contaService.atualizarConta(conta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @GetMapping("/{idUser}")
    public ResponseEntity<?> conta(@PathVariable Integer idUser) {
        try {
            Conta conta = contaService.retornarConta(idUser);
            if (conta == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Conta nao encontrado\"}");
            return ResponseEntity.ok(conta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @DeleteMapping("/{idConta}")
    public ResponseEntity<?> deleteConta(@PathVariable Integer idConta) {
        try {
            if (contaService.retornarConta(idConta) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Conta nao encontrado\"}");
            contaService.deleteConta(idConta);
            return ResponseEntity.ok("{\"message\": \"Conta excluida\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @GetMapping("/saldo/{idConta}")
    public ResponseEntity<?> saldo(@PathVariable Integer idConta) {
        try {
            if (contaService.retornarConta(idConta) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Conta nao encontrado\"}");
            return ResponseEntity.ok("{\"valor\":" + contaService.saldo(idConta) + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @PutMapping("/saldo")
    public ResponseEntity<?> saldo(@RequestBody SaldoDTO saldo) {
        try {
            Conta conta = contaService.retornarConta(saldo.getIdConta());
            if (conta == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Conta nao encontrado\"}");
            return ResponseEntity
                    .ok("{\"valor\":" + contaService.atualizarSaldo(conta, saldo.getSaldo()).getSaldo() + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @GetMapping("/pix/{chave}")
    public ResponseEntity<?> retornarContaChavePix(@PathVariable String chave) {
        try {
            Conta conta = contaService.retornarContaChavePix(chave);
            if (conta == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Conta com chave nao encontrado\"}");

            return ResponseEntity.ok(conta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @PostMapping("/pix")
    public ResponseEntity<?> cadastrarChavePix(@RequestBody ChaveDTO chave) {
        try {
            Conta conta = contaService.retornarConta(chave.getIdConta());
            if (conta == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Conta nao encontrado\"}");
            if (contaService.buscarChaves(chave.getChave()) != null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"status\": \"400 \", message\": \"cadastre uma chave unica\"}");
            return ResponseEntity.ok(contaService.cadastrarChavePix(chave.getChave(), conta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

}
