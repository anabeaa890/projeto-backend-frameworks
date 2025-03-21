package com.example.bia.demo.controller;

import com.example.bia.demo.model.Contato;
import com.example.bia.demo.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatoService service;

    @GetMapping
    public List<Contato> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/agrupados")
    public Map<Character, List<Contato>> listarAgrupadoPorLetra() {
        return service.listarAgrupadoPorLetra();
    }

    @GetMapping("/{id}")
    public Optional<Contato> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Contato salvar(@RequestBody Contato contato) {
        return service.salvar(contato);
    }

    @PutMapping("/{id}")
    public Optional<Contato> atualizar(@PathVariable Long id, @RequestBody Contato contato) {
        return service.atualizar(id, contato);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id) {
        return service.deletar(id);
    }

    @PutMapping("/desativar/{id}")
    public Optional<Contato> desativar(@PathVariable Long id) {
        return service.desativar(id);
    }

    @PutMapping("/favoritar/{id}")
    public Optional<Contato> favoritar(@PathVariable Long id) {
        return service.favoritar(id);
    }
}
