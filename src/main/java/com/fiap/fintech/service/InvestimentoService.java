package com.fiap.fintech.service;

import com.fiap.fintech.model.Investimento;
import com.fiap.fintech.repository.InvestimentoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InvestimentoService {

    // Camada de servico responsavel pelas regras de CRUD de investimentos.
    private final InvestimentoRepository repository;

    public InvestimentoService(InvestimentoRepository repository) {
        this.repository = repository;
    }

    public List<Investimento> listar() {
        return repository.findAll();
    }

    public Investimento buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Investimento", id));
    }

    public Investimento criar(Investimento investimento) {
        investimento.setId(null);
        return repository.save(investimento);
    }

    public Investimento atualizar(Long id, Investimento investimento) {
        buscarPorId(id);
        investimento.setId(id);
        return repository.save(investimento);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}

