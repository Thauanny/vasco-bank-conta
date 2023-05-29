package com.vascobancoconta.vascobancocontaarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vascobancoconta.vascobancocontaarti.models.Conta;
import com.vascobancoconta.vascobancocontaarti.models.Saldo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/contaCorrente")
public class ContaController {
    // @Autowired
    // private ContaService contaService;

    @PostMapping("/{idUser}")
    public ResponseEntity<?> cadastrarConta(@PathVariable Integer idUser, @RequestBody Conta conta) {
        try {
            System.out.println(idUser);
            // chamada service
            return ResponseEntity.ok(conta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @PutMapping("/{idUser}")
    public ResponseEntity<?> atualizarConta(@PathVariable Integer idUser, @RequestBody Conta conta) {
        try {
            System.out.println(idUser);
            // chamada service
            return ResponseEntity.ok(conta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @GetMapping("/{idConta}")
    public ResponseEntity<?> conta(@PathVariable Integer idConta) {
        try {
            // chamada service
            System.out.println(idConta);
            return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @DeleteMapping("/{idConta}")
    public ResponseEntity<?> deleteConta(@PathVariable Integer idConta) {
        try {
            // chamada service
            System.out.println(idConta);
            return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @GetMapping("/saldo/{idConta}")
    public ResponseEntity<?> saldo(@PathVariable Integer idConta) {
        try {
            // chamada service
            System.out.println(idConta);
            return ResponseEntity.ok("{\"valor\":" + 99 + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }

    @PutMapping("/saldo/{idConta}")
    public ResponseEntity<?> saldo(@PathVariable Integer idConta, @RequestBody Saldo saldo) {
        try {
            // chamada service
            System.out.println(idConta);

            return ResponseEntity.ok("{\"valor\":" + saldo.getValor() + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @GetMapping("/extrato/{idConta}")
    public ResponseEntity<?> extrato(@PathVariable Integer idConta) {
        try {
            // chamada service
            System.out.println(idConta);
            return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }
}
