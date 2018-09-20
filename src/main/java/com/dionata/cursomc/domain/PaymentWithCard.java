package com.dionata.cursomc.domain;

import javax.persistence.Entity;

import com.dionata.cursomc.domain.enums.StatusPayment;

@Entity
public class PaymentWithCard extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer numberOfInstallments;

	public PaymentWithCard() {
	}

	public PaymentWithCard(Integer id, StatusPayment status, PurchaseOrder order, Integer numberOfInstallments) {
		super(id, status, order);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

}
