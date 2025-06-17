package com.dbx.meu_primeiro_springboot.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.dbx.meu_primeiro_springboot.exceptions.RecursoNaoEncontradoException;
import com.dbx.meu_primeiro_springboot.model.Produto;
import com.dbx.meu_primeiro_springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
        .orElseThrow((()-> new RecursoNaoEncontradoException("Produto com id "+ id + " não encontado")));
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        if (!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com id "+ id + " não encontado");
        }
        produtoRepository.deleteById(id);
    }
    
}
