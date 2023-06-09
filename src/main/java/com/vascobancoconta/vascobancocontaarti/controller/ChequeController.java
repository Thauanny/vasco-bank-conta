package com.vascobancoconta.vascobancocontaarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vascobancoconta.vascobancocontaarti.models.Cheque;
import com.vascobancoconta.vascobancocontaarti.service.ChequeService;
import com.vascobancoconta.vascobancocontaarti.service.ContaService;

@RestController
@RequestMapping(value = "/contaCorrente/cheque")
public class ChequeController {
    @Autowired
    private ChequeService chequeService;
    @Autowired
    private ContaService contaService;

    @PostMapping("/{idConta}")
    public ResponseEntity<?> cadastrarCheque(@PathVariable Integer idConta, @RequestBody Cheque cheque) {
        try {
            if (contaService.retornarConta(idConta) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Usuario nao encontrado\"}");
            cheque.setIdConta(idConta);
            return ResponseEntity.status(HttpStatus.CREATED).body(chequeService.cadastrarCheque(cheque));
        } catch (Exception e) {
            // enviar log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\": \"500 \", message\": \"Nao foi possivel cadastrar\"}");
        }
    }

    @GetMapping("/all/{idConta}")
    public ResponseEntity<?> cheques(@PathVariable Integer idConta) {
        try {

            if (contaService.retornarConta(idConta) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Usuario nao encontrado\"}");
            return ResponseEntity.status(HttpStatus.OK).body(chequeService.retornarCheques(idConta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @GetMapping("/{idCheque}")
    public ResponseEntity<?> cheque(@PathVariable Integer idCheque) {
        try {

            if (chequeService.retornarCheque(idCheque) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Cheque nao encontrado\"}");
            return ResponseEntity.ok(chequeService.retornarCheque(idCheque));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @GetMapping("/{idCheque}/limite")
    public ResponseEntity<?> limite(@PathVariable Integer idCheque) {
        try {
            if (chequeService.retornarCheque(idCheque) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Cheque nao encontrado\"}");

            return ResponseEntity.ok(chequeService.limite(idCheque));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @PutMapping("/limite")
    public ResponseEntity<?> limite(@RequestBody Cheque cheque) {
        try {
            if (chequeService.retornarCheque(cheque.getId()) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Cheque nao encontrado\"}");
            return ResponseEntity.ok(chequeService.atualizarlimite(cheque));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @GetMapping("/{idCheque}/juros")
    public ResponseEntity<?> juros(@PathVariable Integer idCheque) {
        try {
            if (chequeService.retornarCheque(idCheque) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Cheque nao encontrado\"}");
            return ResponseEntity.ok("{\"valor\":" + chequeService.limite(idCheque) + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @PutMapping("/juros")
    public ResponseEntity<?> juros(@RequestBody Cheque cheque) {
        try {
            if (chequeService.retornarCheque(cheque.getId()) == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"status\": \"404 \", message\": \"Cheque nao encontrado\"}");
            return ResponseEntity.ok(chequeService.atualizarJuros(cheque));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

}
