package com.napp.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.napp.api.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
