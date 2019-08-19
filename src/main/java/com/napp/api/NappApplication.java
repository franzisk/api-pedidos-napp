package com.napp.api;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.napp.api.entities.Cliente;
import com.napp.api.entities.ItemPedido;
import com.napp.api.entities.Pedido;
import com.napp.api.entities.Produto;
import com.napp.api.repositories.ClienteRepository;
import com.napp.api.repositories.PedidoRepository;
import com.napp.api.repositories.ProdutoRepository;

@SpringBootApplication
public class NappApplication {

	public static void main(String[] args) {
		SpringApplication.run(NappApplication.class, args);
	}

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	PedidoRepository pedidoRepository;
	
	// Carga de dados iniciais para testar conforme solicitado em documento
	@PostConstruct
	public void init() {
		long totalClientes = this.clienteRepository.count();
		if (totalClientes < 1) {
			this.clienteRepository.save(new Cliente(1, "Darth Vader"));
			this.clienteRepository.save(new Cliente(2, "Obi-Wan Kenobi"));
			this.clienteRepository.save(new Cliente(3, "Luke Skywalker"));
			this.clienteRepository.save(new Cliente(4, "Imperador Palpatine"));
			this.clienteRepository.save(new Cliente(5, "Han Solo"));
		}

		long totalProdutos = this.produtoRepository.count();
		if (totalProdutos < 1) {
			this.produtoRepository.save(new Produto(1, "Millenium Falcon", BigDecimal.valueOf(550000.0), 0));
			this.produtoRepository.save(new Produto(2, "X-Wing", BigDecimal.valueOf(60000.0), 2));
			this.produtoRepository.save(new Produto(3, "Super Star Destroyer", BigDecimal.valueOf(4570000.0), 0));
			this.produtoRepository.save(new Produto(4, "TIE Fighter", BigDecimal.valueOf(75000.0), 2));
			this.produtoRepository.save(new Produto(5, "Lightsaber", BigDecimal.valueOf(6000.0), 5));
			this.produtoRepository.save(new Produto(6, "DLT-19 Heavy Blaster Rifle", BigDecimal.valueOf(5800.0), 0));
			this.produtoRepository.save(new Produto(7, "DL-44 Heavy Blaster Pistol", BigDecimal.valueOf(1500.0), 10));

		}
		long totalPedidos = this.pedidoRepository.count();
		if (totalPedidos < 1) {
			Pedido pedido1 = new Pedido();
			pedido1.setCliente(this.clienteRepository.findById(1L).get());
			ItemPedido item1 = new ItemPedido();
			item1.setProduto(this.produtoRepository.findById(1L).get());
			item1.setPrecoUnitario(item1.getProduto().getPrecoUnitario());
			item1.setQuantidade(5);
			item1.setRentabilidade(2);
			item1.setValorTotal(new BigDecimal(item1.getPrecoUnitario().doubleValue() * item1.getQuantidade()));
			
			ItemPedido item2 = new ItemPedido();
			item2.setProduto(this.produtoRepository.findById(2L).get());
			item2.setPrecoUnitario(item2.getProduto().getPrecoUnitario());
			item2.setQuantidade(15);
			item2.setRentabilidade(1);
			item2.setValorTotal(new BigDecimal(item2.getPrecoUnitario().doubleValue() * item2.getQuantidade()));
			
			pedido1.getItens().add(item1);
			pedido1.getItens().add(item2);
			pedido1 = this.pedidoRepository.save(pedido1);

			Pedido pedido2 = new Pedido();
			pedido2.setCliente(this.clienteRepository.findById(2L).get());

			ItemPedido item3 = new ItemPedido();
			item3.setProduto(this.produtoRepository.findById(3L).get());
			item3.setPrecoUnitario(item3.getProduto().getPrecoUnitario());
			item3.setQuantidade(2);
			item3.setRentabilidade(0);
			item3.setValorTotal(new BigDecimal(item3.getPrecoUnitario().doubleValue() * item3.getQuantidade()));
			
			ItemPedido item4 = new ItemPedido();
			item4.setProduto(this.produtoRepository.findById(4L).get());
			item4.setPrecoUnitario(item4.getProduto().getPrecoUnitario());
			item4.setQuantidade(15);
			item4.setRentabilidade(1);
			item4.setValorTotal(new BigDecimal(item4.getPrecoUnitario().doubleValue() * item4.getQuantidade()));
			
			pedido2.getItens().add(item3);
			pedido2.getItens().add(item4);
			pedido2 = this.pedidoRepository.save(pedido2);

		}
	}
}
