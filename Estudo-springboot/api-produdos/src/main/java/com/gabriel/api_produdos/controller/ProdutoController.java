package com.gabriel.api_produdos.controller;

import com.gabriel.api_produdos.model.Produto;
import com.gabriel.api_produdos.service.ProdutoService;
import com.gabriel.api_produdos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Diz: "Essa classe recebe requisições HTTP"
@RequestMapping("/produtos") // Diz: "O endereço base é http://localhost:8080/produtos"
public class ProdutoController {
    @Autowired // INJEÇÃO DE DEPENDÊNCIA (Spring, me dê um Repository pronto!)
    private ProdutoService service;

    // 1. GET (Listar tudo)
    // Acessar no navegador: localhost:8080/produtos
    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos(); //O método que faz o select *
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> BuscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2. POST (Criar)
    // Recebe um JSON e salva
    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody Produto produto) {
        try {
            Produto novoProduto = service.salvar(produto);
            return ResponseEntity.ok(novoProduto);
        } catch (RuntimeException e) {
            // Se o Chef reclamar (preço negativo), avisamos o cliente (Erro 400)
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarPorId(@PathVariable Integer id, @RequestBody Produto novosDados) {
        Produto produtoAtualizado = service.atualizar(id,novosDados);

        if(produtoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        boolean deletado = service.deletar(id);

        if(!deletado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}