package br.com.moredevs.pedidos.model.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record PedidoRequest(
        @NotNull Long produtoId,
        @Min(1) int quantidade
) {
}
