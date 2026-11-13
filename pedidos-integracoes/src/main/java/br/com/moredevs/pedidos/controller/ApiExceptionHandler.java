package br.com.moredevs.pedidos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

// ============================================================
// OBSERVAÇÃO DIDÁTICA
// ============================================================
// Não faz parte do conteúdo principal da Aula 1 ou 2.
// Foi mantido somente um tratamento mínimo para facilitar os testes.
// O tratamento global de erros será aprofundado posteriormente.
// ============================================================
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> tratar(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of("erro", ex.getMessage()));
    }
}
