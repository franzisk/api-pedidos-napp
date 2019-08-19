package com.napp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napp.api.entities.Produto;
import com.napp.api.repositories.ProdutoRepository;

@Component
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> listar() {
		return (List<Produto>) this.produtoRepository.findAll();
	}
}
