package br.com.moredevs.pedidos.model.dtos;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

// AULA 1: contrato original da API (V1).
public record PedidoResponse(
        UUID id,
        Long produtoId,
        String produto,
        int quantidade,
        BigDecimal valorTotal,
        String status,
        Instant criadoEm
) {
}
