package br.com.moredevs.pedidos.model.dtos;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

// AULA 1: novo contrato da API (V2).
// Mantemos V1 funcionando para não quebrar quem ainda usa o contrato antigo.
public record PedidoResponseV2(
        UUID id,
        ProdutoResumo produto,
        int quantidade,
        BigDecimal total,
        String status,
        Instant criadoEm
) {
    public record ProdutoResumo(Long id, String nome) {
    }
}
