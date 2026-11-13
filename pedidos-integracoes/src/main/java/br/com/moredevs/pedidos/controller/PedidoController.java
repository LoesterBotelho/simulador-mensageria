package br.com.moredevs.pedidos.controller;

import br.com.moredevs.pedidos.model.dtos.PedidoRequest;
import br.com.moredevs.pedidos.model.dtos.PedidoResponse;
import br.com.moredevs.pedidos.model.dtos.PedidoResponseV2;
import br.com.moredevs.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // ============================================================
    // AULA 1 - VERSÃO 1
    // ============================================================
    // Mantemos o contrato antigo funcionando.
    // ============================================================
    @PostMapping("/v1/pedidos")
    public PedidoResponse criarV1(@Valid @RequestBody PedidoRequest request) {
        return service.criar(request);
    }

    // ============================================================
    // AULA 1 - VERSÃO 2
    // ============================================================
    // Novo contrato coexistindo com a V1.
    // ============================================================
    @PostMapping("/v2/pedidos")
    public PedidoResponseV2 criarV2(@Valid @RequestBody PedidoRequest request) {
        return service.criarV2(request);
    }
}
