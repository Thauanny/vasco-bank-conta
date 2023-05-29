package com.vascobancoconta.vascobancocontaarti.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vascobancoconta.vascobancocontaarti.models.Cheque;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/contaCorrente/cheque")
public class ChequeController {
    // @Autowired
    // private ChequeService chequeService;

    @PostMapping("/criar/{idConta}")
    public ResponseEntity<?> cadastrarCheque(@PathVariable Integer idConta, @RequestBody Cheque cheque) {
        try {
            // chamada service
            System.out.println(idConta);

            return ResponseEntity.ok(cheque);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @GetMapping("/all/{idConta}")
    public ResponseEntity<?> cheques(@PathVariable Integer idConta) {
        try {
            // chamada service
            System.out.println(idConta);
            return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }
    @GetMapping("/{idConta}/{idCheque}")
    public ResponseEntity<?> cheque(@PathVariable Integer idConta, @PathVariable Integer idCheque) {
        try {
            // chamada service
            System.out.println(idConta);
            System.out.println(idCheque);
            return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @GetMapping("/{idConta}/{idCheque}/limite")
    public ResponseEntity<?> limite(@PathVariable Integer idConta, @PathVariable Integer idCheque) {
        try {
            // chamada service
            System.out.println(idConta);
            System.out.println(idCheque);
            return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @PutMapping("/{idConta}/{idCheque}/limite")
    public ResponseEntity<?> limite(@PathVariable Integer idConta, @RequestBody Cheque cheque) {
        try {
            // chamada service
            System.out.println(idConta);
            return ResponseEntity.ok(cheque);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @GetMapping("/{idConta}/{idCheque}/juros")
    public ResponseEntity<?> juros(@PathVariable Integer idConta, @PathVariable Integer idCheque) {
        try {
            // chamada service
            System.out.println(idConta);
            System.out.println(idCheque);
            return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @PutMapping("/{idConta}/{idCheque}/juros")
    public ResponseEntity<?> juros(@PathVariable Integer idConta, @RequestBody Cheque cheque) {
        try {
            // chamada service
            System.out.println(idConta);
            return ResponseEntity.ok(cheque);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

}
