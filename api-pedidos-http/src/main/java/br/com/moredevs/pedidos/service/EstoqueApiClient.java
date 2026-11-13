package br.com.moredevs.pedidos.service;

import br.com.moredevs.pedidos.model.EstoqueResposta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class EstoqueApiClient {
    private final RestClient restClient;
    private final String baseUrl;

    public EstoqueApiClient(RestClient restClient,
                            @Value("${estoque.api.base-url}") String baseUrl) {
        this.restClient = restClient;
        this.baseUrl = baseUrl;
    }

    public EstoqueResposta consultar(Long produtoId, Integer quantidade) {
        // Esta chamada HTTP sai da aplicação Pedidos e chega à aplicação Estoque.
        return restClient.get()
                .uri(baseUrl + "/api/estoque/produtos/{id}?quantidade={quantidade}",
                        produtoId, quantidade)
                .retrieve()
                .body(EstoqueResposta.class);
    }
}
