package com.napp.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.napp.api.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
