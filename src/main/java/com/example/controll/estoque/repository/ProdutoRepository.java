package com.example.controll.estoque.repository;

import com.example.controll.estoque.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    boolean existsBySku(String sku);
}
