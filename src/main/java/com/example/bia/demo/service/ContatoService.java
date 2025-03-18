package com.example.bia.demo.service;

import com.example.bia.demo.model.Contato;
import com.example.bia.demo.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<Contato> listarTodos() {
        return repository.findAll();
    }

    public Optional<Contato> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Contato salvar(Contato contato) {
        return repository.save(contato);
    }

    public Contato atualizar(Long id, Contato contato) {
        contato.setId(id);
        return repository.save(contato);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public void desativar(Long id) {
        Optional<Contato> contatoOpt = repository.findById(id);
        if (contatoOpt.isPresent()) {
            Contato contato = contatoOpt.get();
            contato.setSnAtivo("N");  // Supondo que você tenha um método setSnAtivo
            repository.save(contato);
        }
    }
}