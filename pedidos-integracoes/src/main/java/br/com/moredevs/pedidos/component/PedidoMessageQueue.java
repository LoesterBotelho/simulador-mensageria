package br.com.moredevs.pedidos.component;

import br.com.moredevs.pedidos.model.PedidoCriadoEvent;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// ============================================================
// AULA 2 - FILA EM MEMÓRIA
// ============================================================
// Esta fila SIMULA o papel de uma fila/broker de mensagens.
// Não é RabbitMQ.
//
// Java Queue -> simulação didática
// RabbitMQ   -> broker real em uma aplicação real
// ============================================================
@Component
public class PedidoMessageQueue {

    private final Queue<PedidoCriadoEvent> fila = new ConcurrentLinkedQueue<>();

    public void enviar(PedidoCriadoEvent evento) {
        fila.offer(evento);
    }

    public PedidoCriadoEvent receber() {
        return fila.poll();
    }

    public int tamanho() {
        return fila.size();
    }
}
