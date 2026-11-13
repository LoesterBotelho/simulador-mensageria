package br.com.moredevs.pedidos.component;

import br.com.moredevs.pedidos.model.PedidoCriadoEvent;
import br.com.moredevs.pedidos.service.EstoqueService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// ============================================================
// AULA 2 - CONSUMIDOR
// ============================================================
// O consumidor verifica a fila e processa as mensagens.
// O @Scheduled é apenas uma simulação didática do consumo.
// ============================================================
@Component
public class EstoqueConsumer {

    private static final Logger log = LoggerFactory.getLogger(EstoqueConsumer.class);

    private final PedidoMessageQueue queue;
    private final EstoqueService estoqueService;

    public EstoqueConsumer(PedidoMessageQueue queue, EstoqueService estoqueService) {
        this.queue = queue;
        this.estoqueService = estoqueService;
    }

    @Scheduled(fixedDelay = 1000)
    public void processar() {
        PedidoCriadoEvent evento = queue.receber();

        if (evento == null) {
            return;
        }

        log.info("AULA 2 | CONSUMIDOR | Mensagem recebida: pedidoId={}", evento.pedidoId());
        estoqueService.atualizarEstoque(evento);
    }
}
