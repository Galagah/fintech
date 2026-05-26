package com.fiap.fintech.service;

import com.fiap.fintech.model.Usuario;
import com.fiap.fintech.repository.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    // Camada de servico responsavel pelas regras de CRUD de usuarios.
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", id));
    }

    public Usuario criar(Usuario usuario) {
        usuario.setId(null);
        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        buscarPorId(id);
        usuario.setId(id);
        return repository.save(usuario);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}

