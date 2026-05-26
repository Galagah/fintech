package com.fiap.fintech.controller;

import com.fiap.fintech.model.Investimento;
import com.fiap.fintech.service.InvestimentoService;
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
@RequestMapping("/api/investimentos")
public class InvestimentoController {

    // Controller REST que expoe os endpoints de investimentos.
    private final InvestimentoService service;

    public InvestimentoController(InvestimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Investimento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Investimento buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Investimento> criar(@Valid @RequestBody Investimento investimento) {
        Investimento criado = service.criar(investimento);
        return ResponseEntity.created(URI.create("/api/investimentos/" + criado.getId())).body(criado);
    }

    @PutMapping("/{id}")
    public Investimento atualizar(@PathVariable Long id, @Valid @RequestBody Investimento investimento) {
        return service.atualizar(id, investimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

