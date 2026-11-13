package br.com.moredevs.pedidos.controller;

import br.com.moredevs.pedidos.model.Produto;
import br.com.moredevs.pedidos.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return service.buscar(id);
    }
}
