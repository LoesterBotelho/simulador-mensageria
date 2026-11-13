package br.com.moredevs.estoque.model;

public record EstoqueResposta(
        Long produtoId,
        String produto,
        Integer quantidadeDisponivel,
        boolean disponivel,
        String mensagem
) {}
