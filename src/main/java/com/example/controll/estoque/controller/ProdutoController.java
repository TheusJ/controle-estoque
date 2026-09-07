package com.example.controll.estoque.controller;

import com.example.controll.estoque.model.ProdutoModel;
import com.example.controll.estoque.repository.ProdutoRepository;
import com.example.controll.estoque.service.FuncionarioService;
import com.example.controll.estoque.service.ProdutoService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ProdutoModel> cadastrarProduto(@RequestBody ProdutoModel produtoModel) {
        produtoService.cadastrarProduto(produtoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoModel);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoModel> buscarProdutoById(@PathVariable Long id) {



        return produtoService.buscarProdutoById(id).map(produtoId -> ResponseEntity.status(HttpStatus.OK).body(produtoId)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ProdutoModel> buscarTodosProdutos() {
        List<ProdutoModel> todosProdutos = produtoService.buscarTodosProdutos();

        return todosProdutos;
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoModel> autlizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {

        ProdutoModel produtoAtualizado = produtoService.atualizarProduto(id, produtoModel);

        return ResponseEntity.status(HttpStatus.OK).body(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);

        return ResponseEntity.noContent().build();

    }
}
