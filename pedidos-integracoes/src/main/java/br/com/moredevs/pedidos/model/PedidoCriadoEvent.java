package br.com.moredevs.pedidos.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

// ============================================================
// AULA 2 - EVENTO DE MENSAGERIA
// ============================================================
// Representa algo que aconteceu no sistema:
// "Um pedido foi criado."
// ============================================================
public record PedidoCriadoEvent(
        UUID pedidoId,
        Long produtoId,
        String produto,
        int quantidade,
        BigDecimal valorTotal,
        Instant ocorridoEm
) {
}
