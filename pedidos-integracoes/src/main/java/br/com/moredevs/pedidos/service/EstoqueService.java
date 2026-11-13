package br.com.moredevs.pedidos.service;

import br.com.moredevs.pedidos.model.PedidoCriadoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// ============================================================
// AULA 2 - SERVIÇO DO ESTOQUE
// ============================================================
@Service
public class EstoqueService {

    private static final Logger log = LoggerFactory.getLogger(EstoqueService.class);

    public void atualizarEstoque(PedidoCriadoEvent evento) {
        // Nesta aula ainda não existe banco de dados.
        // Apenas simulamos o processamento do estoque.
        log.info(
                "AULA 2 | ESTOQUE | Processando pedidoId={}, produto={}, quantidade={}",
                evento.pedidoId(), evento.produto(), evento.quantidade()
        );
    }
}
