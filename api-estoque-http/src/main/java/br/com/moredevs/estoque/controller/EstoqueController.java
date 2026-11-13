package br.com.moredevs.estoque.controller;

import br.com.moredevs.estoque.model.EstoqueResposta;
import br.com.moredevs.estoque.service.EstoqueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {
    private final EstoqueService service;

    public EstoqueController(EstoqueService service) {
        this.service = service;
    }

    @GetMapping("/produtos/{id}")
    public EstoqueResposta consultar(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") Integer quantidade) {
        System.out.println("[API ESTOQUE] Recebi uma chamada HTTP para o produto " + id);
        return service.consultar(id, quantidade);
    }
}
