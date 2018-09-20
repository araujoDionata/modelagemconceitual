package com.dionata.cursomc.domain.enums;

public enum StatusPayment {
	PENDING(1, "Pendente"), PAID(2, "Pago"), CANCELED(3, "Cancelado");
	
	private int cod;
	private String description;

	private StatusPayment(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static StatusPayment toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusPayment x : StatusPayment.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("ID inválido: " + cod);
	}

}
