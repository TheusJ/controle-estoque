package com.example.controll.estoque.service;

import com.example.controll.estoque.exception.ProdutoException;
import com.example.controll.estoque.model.ProdutoModel;
import com.example.controll.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel cadastrarProduto(ProdutoModel produtoModel) {

        boolean existPrdotudo = produtoRepository.existsBySku(produtoModel.getSku());

        if (existPrdotudo) {
            throw new ProdutoException("Sku do produto já existente");
        }


        produtoModel = produtoRepository.save(produtoModel);
        return produtoModel;
    }


    public Optional<ProdutoModel> buscarProdutoById(Long id) {
        Optional<ProdutoModel> produtoId = produtoRepository.findById(id);

        if (produtoId.isEmpty()) {
            throw new ProdutoException("ID do produto informado não encontrado em nosso Banco de Dados");
        }

        return produtoId;
    }

    public List<ProdutoModel> buscarTodosProdutos() {
        List<ProdutoModel> todosProdutos = produtoRepository.findAll();

        if (todosProdutos.isEmpty()) {
            throw new ProdutoException("Não temos produtos cadastrado!");
        }

        return todosProdutos;
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoModel) {
        ProdutoModel produtoAtualizado = produtoRepository.findById(id).orElseThrow(() -> new ProdutoException("Produto não encontrado no nosso Banco de Dados"));


        produtoAtualizado.setNome(produtoModel.getNome());
        produtoAtualizado.setSku(produtoModel.getSku());
        produtoAtualizado.setDescricao(produtoModel.getDescricao());
        produtoAtualizado.setQuantidade(produtoModel.getQuantidade());

        return produtoRepository.save(produtoAtualizado);

    }

    public Optional<ProdutoModel> deletarProduto(Long id) {
        Optional<ProdutoModel> idProdutoDeletar = produtoRepository.findById(id);

        if (idProdutoDeletar.isEmpty()) {
            throw new ProdutoException("ID do produto informado não encontrado em nosso Banco de Dados");
        }

        produtoRepository.deleteById(id);

        return idProdutoDeletar;

    }

}
