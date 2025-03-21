package com.example.bia.demo.service;

import com.example.bia.demo.model.Contato;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    private List<Contato> contatos = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Contato> listarTodos() {
        return contatos;
    }

    public Map<Character, List<Contato>> listarAgrupadoPorLetra() {
        return contatos.stream()
                .filter(c -> c.getNome() != null && !c.getNome().isEmpty())
                .sorted(Comparator.comparing(Contato::getNome))
                .collect(Collectors.groupingBy(c -> Character.toUpperCase(c.getNome().charAt(0))));
    }

    public Optional<Contato> buscarPorId(Long id) {
        return contatos.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Contato salvar(Contato contato) {
        contato.setId(contadorId++);
        contato.setSnAtivo("S");
        contatos.add(contato);
        return contato;
    }

    public Optional<Contato> atualizar(Long id, Contato novoContato) {
        return buscarPorId(id).map(contato -> {
            contato.setNome(novoContato.getNome());
            contato.setEmail(novoContato.getEmail());
            contato.setTelefone(novoContato.getTelefone());
            return contato;
        });
    }

    public boolean deletar(Long id) {
        return contatos.removeIf(c -> c.getId().equals(id));
    }

    public Optional<Contato> desativar(Long id) {
        return buscarPorId(id).map(contato -> {
            contato.setSnAtivo("N");
            return contato;
        });
    }

    public Optional<Contato> favoritar(Long id) {
        return buscarPorId(id).map(contato -> {
            contato.setSnAtivo("F");
            return contato;
        });
    }
}
