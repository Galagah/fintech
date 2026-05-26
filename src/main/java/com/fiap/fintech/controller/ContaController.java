package com.fiap.fintech.controller;

import com.fiap.fintech.model.Conta;
import com.fiap.fintech.service.ContaService;
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
@RequestMapping("/api/contas")
public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Conta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Conta buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Conta> criar(@Valid @RequestBody Conta conta) {
        Conta criado = service.criar(conta);
        return ResponseEntity.created(URI.create("/api/contas/" + criado.getId())).body(criado);
    }

    @PutMapping("/{id}")
    public Conta atualizar(@PathVariable Long id, @Valid @RequestBody Conta conta) {
        return service.atualizar(id, conta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

