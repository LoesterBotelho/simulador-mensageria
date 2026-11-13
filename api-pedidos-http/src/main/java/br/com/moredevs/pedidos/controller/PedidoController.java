package br.com.moredevs.pedidos.controller;

import br.com.moredevs.pedidos.model.PedidoRequest;
import br.com.moredevs.pedidos.model.PedidoResponse;
import br.com.moredevs.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponse criar(@Valid @RequestBody PedidoRequest request) {
        return service.criar(request);
    }
}
