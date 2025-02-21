package com.example.demo.controllers;

import com.example.demo.models.ItemColecao;
import com.example.demo.repositories.ItemColecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
public class ItemColecaoController {

    @Autowired
    private ItemColecaoRepository itemColecaoRepository;

    // Criar item
    @PostMapping
    public ItemColecao criarItem(@RequestBody ItemColecao item) {
        return itemColecaoRepository.save(item);
    }

    // Listar itens
    @GetMapping
    public List<ItemColecao> listaItens() {
        return itemColecaoRepository.findAll();
    }

    // Buscar item por ID
    @GetMapping("/{id}")
    public ItemColecao buscaItem(@PathVariable Long id) {
        return itemColecaoRepository.findById(id).orElse(null);
    }

    // Atualizar item
    @PutMapping("/{id}")
    public ItemColecao atualizarItem(@PathVariable Long id, @RequestBody ItemColecao itemAtualizado) {
        return itemColecaoRepository.findById(id)
            .map(item -> {
                item.setTitulo(itemAtualizado.getTitulo());
                item.setTipo(itemAtualizado.getTipo());
                item.setDescricao(itemAtualizado.getDescricao());
                item.setAnoLancamento(itemAtualizado.getAnoLancamento());
                item.setUrlImagem(itemAtualizado.getUrlImagem());
                return itemColecaoRepository.save(item);
            })
            .orElse(null);
    }

    // Deletar item por ID
    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable Long id) {
        itemColecaoRepository.deleteById(id);
    }
}
