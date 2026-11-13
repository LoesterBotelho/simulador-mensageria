package br.com.moredevs.pedidos.service;

import br.com.moredevs.pedidos.component.PedidoProducer;
import br.com.moredevs.pedidos.model.PedidoCriadoEvent;
import br.com.moredevs.pedidos.model.Produto;
import br.com.moredevs.pedidos.model.dtos.PedidoRequest;
import br.com.moredevs.pedidos.model.dtos.PedidoResponse;
import br.com.moredevs.pedidos.model.dtos.PedidoResponseV2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
public class PedidoService {

    private final ProdutoService produtoService;
    private final PedidoProducer pedidoProducer;

    public PedidoService(ProdutoService produtoService, PedidoProducer pedidoProducer) {
        this.produtoService = produtoService;
        this.pedidoProducer = pedidoProducer;
    }

    // ============================================================
    // AULA 1 - CRIAÇÃO DO PEDIDO / CONTRATO V1
    // ============================================================
    public PedidoResponse criar(PedidoRequest request) {
        Produto produto = produtoService.buscar(request.produtoId());

        if (produto.estoque() < request.quantidade()) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }

        UUID id = UUID.randomUUID();
        BigDecimal total = produto.preco()
                .multiply(BigDecimal.valueOf(request.quantidade()));

        PedidoResponse pedido = new PedidoResponse(
                id,
                produto.id(),
                produto.nome(),
                request.quantidade(),
                total,
                "CRIADO",
                Instant.now()
        );

        // ========================================================
        // AULA 2 - PUBLICAÇÃO DO EVENTO
        // ========================================================
        // O pedido foi criado. Agora avisamos outros componentes
        // por meio de uma mensagem/evento.
        PedidoCriadoEvent evento = new PedidoCriadoEvent(
                pedido.id(),
                produto.id(),
                produto.nome(),
                pedido.quantidade(),
                pedido.valorTotal(),
                Instant.now()
        );

        pedidoProducer.publicar(evento);

        return pedido;
    }

    // ============================================================
    // AULA 1 - NOVO CONTRATO V2
    // ============================================================
    public PedidoResponseV2 criarV2(PedidoRequest request) {
        PedidoResponse pedidoV1 = criar(request);

        return new PedidoResponseV2(
                pedidoV1.id(),
                new PedidoResponseV2.ProdutoResumo(
                        pedidoV1.produtoId(),
                        pedidoV1.produto()
                ),
                pedidoV1.quantidade(),
                pedidoV1.valorTotal(),
                pedidoV1.status(),
                pedidoV1.criadoEm()
        );
    }
}
