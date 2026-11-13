package br.com.moredevs.pedidos.component;

import br.com.moredevs.pedidos.model.PedidoCriadoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// ============================================================
// AULA 2 - PRODUTOR
// ============================================================
// O produtor é responsável por publicar a mensagem.
// Nesta aula, ele coloca a mensagem em uma fila em memória.
// ============================================================
@Component
public class PedidoProducer {

    private static final Logger log = LoggerFactory.getLogger(PedidoProducer.class);

    private final PedidoMessageQueue queue;

    public PedidoProducer(PedidoMessageQueue queue) {
        this.queue = queue;
    }

    public void publicar(PedidoCriadoEvent evento) {
        queue.enviar(evento);
        log.info("AULA 2 | PRODUTOR | Evento publicado: pedidoId={}", evento.pedidoId());
    }
}
