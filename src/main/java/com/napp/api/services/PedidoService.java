package com.napp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napp.api.entities.Pedido;
import com.napp.api.repositories.ItemPedidoRepository;
import com.napp.api.repositories.PedidoRepository;

@Component
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	public List<Pedido> listarPedidos() {
		return (List<Pedido>) this.pedidoRepository.findAll();
	}

	public Pedido salvar(Pedido item) {
		return this.pedidoRepository.save(item);
	}

	public boolean deletar(Long id) {
		this.pedidoRepository.delete(this.pedidoRepository.findById(id).get());
		return true;
	}

	public boolean deletarItem(Long idItem) {
		this.itemPedidoRepository.deleteById(idItem);
		return true;
	}
}
