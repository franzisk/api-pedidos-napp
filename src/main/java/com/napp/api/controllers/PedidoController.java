package com.napp.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napp.api.entities.Pedido;
import com.napp.api.exceptions.SaveUpdateException;
import com.napp.api.services.PedidoService;
import com.napp.api.util.Const;

@CrossOrigin
@RestController
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	// Listar pedidos
	@GetMapping(value = { "/listar" }, headers = { Const.ACCEPT_JSON })
	public ResponseEntity<?> listar(HttpServletRequest request) {
		List<Pedido> item = this.pedidoService.listarPedidos();
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	// Salvar pedido
	@PostMapping(value = "/salvar", headers = { Const.ACCEPT_JSON })
	public ResponseEntity<?> salvar(HttpServletRequest request, @RequestBody Pedido item) throws Exception {
		try {
			return new ResponseEntity<>(this.pedidoService.salvar(item), HttpStatus.OK);
		} catch (Exception ex) {
			throw new SaveUpdateException("Erro ao salvar: " + ex.getMessage());
		}
	}

	// Deletar pedido
	@DeleteMapping(value = "/deletar/{id}", headers = Const.ACCEPT_JSON)
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(this.pedidoService.deletar(id), HttpStatus.OK);
		} catch (Exception ex) {
			throw new SaveUpdateException(ex.getMessage());
		}
	}

	// Deletar apenas um item do pedido
	@DeleteMapping(value = "/deletar-item/{idItem}", headers = Const.ACCEPT_JSON)
	public ResponseEntity<?> deletarItem(@PathVariable("idItem") Long idItem) {
		try {
			return new ResponseEntity<>(this.pedidoService.deletarItem(idItem), HttpStatus.OK);
		} catch (Exception ex) {
			throw new SaveUpdateException(ex.getMessage());
		}
	}

}
