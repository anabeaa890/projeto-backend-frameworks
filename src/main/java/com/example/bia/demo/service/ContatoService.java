package com.example.bia.demo.service;

import com.example.bia.demo.model.Contato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private List<Contato> contatos = new ArrayList<>();

    public List<Contato> listarTodos() {
        contatos.add(new Contato());
        return contatos;
    }

//    public Optional<Contato> buscarPorId(Long id) {
//        return repository.findById(id);
//    }

    public Contato salvar(Contato contato) {
        contatos.add(contato);
        return contato;
    }

//    public Contato atualizar(Long id, Contato contato) {
//        contato.setId(id);
//        return repository.save(contato);
//    }
//
//    public void deletar(Long id) {
//        repository.deleteById(id);
//    }

//    public void desativar(Long id) {
//        Optional<Contato> contatoOpt = repository.findById(id);
//        if (contatoOpt.isPresent()) {
//            Contato contato = contatoOpt.get();
//            contato.setSnAtivo("N");  // Supondo que você tenha um método setSnAtivo
//            repository.save(contato);
//        }
//    }
}