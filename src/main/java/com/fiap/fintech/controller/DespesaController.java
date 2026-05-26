package com.fiap.fintech.controller;

import com.fiap.fintech.model.Despesa;
import com.fiap.fintech.service.DespesaService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    // Controller REST que expoe os endpoints de despesas.
    private final DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Despesa> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Despesa buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Despesa> criar(@Valid @RequestBody Despesa despesa) {
        Despesa criado = service.criar(despesa);
        return ResponseEntity.created(URI.create("/api/despesas/" + criado.getId())).body(criado);
    }

    @PutMapping("/{id}")
    public Despesa atualizar(@PathVariable Long id, @Valid @RequestBody Despesa despesa) {
        return service.atualizar(id, despesa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

