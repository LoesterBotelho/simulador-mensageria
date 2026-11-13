package br.com.moredevs.pedidos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> tratarRegraNegocio(IllegalArgumentException ex) {
        return Map.of("dataHora", Instant.now(), "status", 400, "erro", ex.getMessage());
    }

    @ExceptionHandler(org.springframework.web.client.RestClientException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public Map<String, Object> tratarEstoqueIndisponivel(Exception ex) {
        return Map.of("dataHora", Instant.now(), "status", 503,
                "erro", "A API de Estoque não respondeu. Verifique se a aplicação Estoque está ligada.");
    }
}
