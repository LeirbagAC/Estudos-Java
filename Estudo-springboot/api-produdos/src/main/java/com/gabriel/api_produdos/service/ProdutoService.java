package com.gabriel.api_produdos.service;

import com.gabriel.api_produdos.model.Produto;
import com.gabriel.api_produdos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Importante: Diz ao Spring que aqui tem Regras de Negócio
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository; // O Chef chama o Estoquista

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Produto salvar(Produto produto) {
        if (produto.getPreco() < 0) {
            throw new RuntimeException("O preço não pode ser negativo!");
        }
        return repository.save(produto);
    }

    public Produto atualizar(Integer id, Produto produtoAtualizado) {
        return repository.findById(id)
                .map(produtoExistente -> {
                    produtoExistente.setNome(produtoAtualizado.getNome());
                    produtoExistente.setPreco(produtoAtualizado.getPreco());
                    return repository.save(produtoExistente);
                })
                .orElse(null); // Ou lançar erro
    }

    public boolean deletar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}