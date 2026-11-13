package br.com.moredevs.estoque.service;

import br.com.moredevs.estoque.model.EstoqueResposta;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EstoqueService {
    private final Map<Long, Integer> quantidades = new ConcurrentHashMap<>(
            Map.of(1L, 10, 2L, 3, 3L, 0));

    private final Map<Long, String> nomes = Map.of(
            1L, "Teclado",
            2L, "Mouse",
            3L, "Monitor"
    );

    public EstoqueResposta consultar(Long produtoId, Integer quantidadeSolicitada) {
        Integer disponivel = quantidades.get(produtoId);
        String nome = nomes.get(produtoId);

        if (disponivel == null || nome == null) {
            return new EstoqueResposta(produtoId, "Desconhecido", 0, false,
                    "Produto não encontrado no estoque.");
        }

        boolean temQuantidade = disponivel >= quantidadeSolicitada;
        return new EstoqueResposta(produtoId, nome, disponivel, temQuantidade,
                temQuantidade ? "Estoque disponível." : "Quantidade insuficiente.");
    }
}
