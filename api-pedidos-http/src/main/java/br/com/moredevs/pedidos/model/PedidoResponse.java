package br.com.moredevs.pedidos.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record PedidoResponse(
        UUID pedidoId,
        Long produtoId,
        String cliente,
        Integer quantidade,
        BigDecimal valorTotal,
        String status,
        Instant criadoEm,
        String verificacaoEstoque
) {}
