package com.dionata.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dionata.cursomc.domain.Client;
import com.dionata.cursomc.services.ClientService;

@RestController
@RequestMapping(value = "/clientes")
public class ClientResource {

	@Autowired
	private ClientService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Client obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

}
