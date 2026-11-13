package br.com.moredevs.pedidos.service;

import br.com.moredevs.pedidos.model.EstoqueResposta;
import br.com.moredevs.pedidos.model.PedidoRequest;
import br.com.moredevs.pedidos.model.PedidoResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
public class PedidoService {
    private final EstoqueApiClient estoqueApiClient;

    public PedidoService(EstoqueApiClient estoqueApiClient) {
        this.estoqueApiClient = estoqueApiClient;
    }

    public PedidoResponse criar(PedidoRequest request) {
        // O pedido chama a API de Estoque e espera a resposta: comunicação síncrona.
        EstoqueResposta estoque = estoqueApiClient.consultar(
                request.produtoId(), request.quantidade());

        if (!estoque.disponivel()) {
            throw new IllegalArgumentException("Não foi possível criar o pedido: " + estoque.mensagem());
        }

        BigDecimal valorUnitario = request.produtoId() == 1L
                ? new BigDecimal("100.00") : new BigDecimal("50.00");
        BigDecimal total = valorUnitario.multiply(BigDecimal.valueOf(request.quantidade()));

        return new PedidoResponse(
                UUID.randomUUID(),
                request.produtoId(),
                request.cliente(),
                request.quantidade(),
                total,
                "CRIADO",
                Instant.now(),
                "Resposta recebida da API de Estoque: " + estoque.mensagem()
        );
    }
}
