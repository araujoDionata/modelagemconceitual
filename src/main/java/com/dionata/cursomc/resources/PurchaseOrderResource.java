package com.dionata.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dionata.cursomc.domain.PurchaseOrder;
import com.dionata.cursomc.services.PurchaseOrderService;

@RestController
@RequestMapping(value = "/pedidos")
public class PurchaseOrderResource {

	@Autowired
	private PurchaseOrderService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PurchaseOrder> find(@PathVariable Integer id) {

		PurchaseOrder obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

}
