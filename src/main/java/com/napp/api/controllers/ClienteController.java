package com.napp.api.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napp.api.services.ClienteService;
import com.napp.api.util.Const;

@CrossOrigin
@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// Listar os cleintes
	@GetMapping(value = { "/listar" }, headers = { Const.ACCEPT_JSON })
	public ResponseEntity<?> listar(HttpServletRequest request) {
		return new ResponseEntity<>(this.clienteService.listar(), HttpStatus.OK);
	}

}
