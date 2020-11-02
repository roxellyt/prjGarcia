package com.app.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.app.model.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
	
}
	
