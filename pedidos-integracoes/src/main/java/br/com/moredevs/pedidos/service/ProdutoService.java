package br.com.moredevs.pedidos.service;

import br.com.moredevs.pedidos.model.Produto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ProdutoService {

    private final Map<Long, Produto> produtos = Map.of(
            1L, new Produto(1L, "Notebook", new BigDecimal("3500.00"), 10),
            2L, new Produto(2L, "Mouse", new BigDecimal("80.00"), 50),
            3L, new Produto(3L, "Teclado", new BigDecimal("150.00"), 20)
    );

    public Produto buscar(Long id) {
        Produto produto = produtos.get(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado: " + id);
        }
        return produto;
    }
}
