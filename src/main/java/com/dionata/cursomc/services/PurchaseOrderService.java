package com.dionata.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dionata.cursomc.domain.PurchaseOrder;
import com.dionata.cursomc.repositories.PurchaseOrderRepository;
import com.dionata.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository repo;

	public PurchaseOrder find(Integer id) {
		Optional<PurchaseOrder> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PurchaseOrder.class.getName()));
	}

}
