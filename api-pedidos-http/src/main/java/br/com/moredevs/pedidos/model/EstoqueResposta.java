package br.com.moredevs.pedidos.model;

public record EstoqueResposta(
        Long produtoId,
        String produto,
        Integer quantidadeDisponivel,
        boolean disponivel,
        String mensagem
) {}
