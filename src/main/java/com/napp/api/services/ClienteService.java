package com.napp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napp.api.entities.Cliente;
import com.napp.api.repositories.ClienteRepository;

@Component
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return (List<Cliente>) this.clienteRepository.findAll();
	}
}
