package com.dbx.meu_primeiro_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbx.meu_primeiro_springboot.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
    
}
