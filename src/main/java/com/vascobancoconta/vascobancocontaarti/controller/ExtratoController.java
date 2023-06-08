package com.vascobancoconta.vascobancocontaarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vascobancoconta.vascobancocontaarti.models.enums.INTERVALO;
import com.vascobancoconta.vascobancocontaarti.service.ExtratoService;

@RestController
@RequestMapping(value = "/extrato")
public class ExtratoController {
    @Autowired
    private ExtratoService extratoService;

    @GetMapping("/{intervalo}")
    public ResponseEntity<?> extratoDia(@PathVariable Integer idConta, @PathVariable INTERVALO intervalo) {
        try {
            switch (intervalo) {
                case DIA:
                    return ResponseEntity.ok(extratoService.extratoDia(idConta));
                case MES:
                    return ResponseEntity.ok(extratoService.extratoMes(idConta));
                default:
                    return ResponseEntity.ok(extratoService.extratoAno(idConta));
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }

    }
}
