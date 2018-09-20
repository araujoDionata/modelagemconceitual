package com.dionata.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.dionata.cursomc.domain.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PaymentSlip extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateMaturity;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date datePayment;

	public PaymentSlip() {
	}

	public PaymentSlip(Integer id, StatusPayment status, PurchaseOrder order, Date dateMaturity, Date datePayment) {
		super(id, status, order);
		this.dateMaturity = dateMaturity;
		this.datePayment = datePayment;
	}

	public Date getDateMaturity() {
		return dateMaturity;
	}

	public void setDateMaturity(Date dateMaturity) {
		this.dateMaturity = dateMaturity;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

}
