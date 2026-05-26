package com.fiap.fintech.service;

import com.fiap.fintech.model.Despesa;
import com.fiap.fintech.repository.DespesaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    private final DespesaRepository repository;

    public DespesaService(DespesaRepository repository) {
        this.repository = repository;
    }

    public List<Despesa> listar() {
        return repository.findAll();
    }

    public Despesa buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Despesa", id));
    }

    public Despesa criar(Despesa despesa) {
        despesa.setId(null);
        return repository.save(despesa);
    }

    public Despesa atualizar(Long id, Despesa despesa) {
        buscarPorId(id);
        despesa.setId(id);
        return repository.save(despesa);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}

