package br.com.easymoney.core.enums;

import lombok.Getter;

@Getter
public enum PersonType {

	PF("PESSOA FISICA", 11),PJ("PESSOA JURIDICA", 14),EU("ESTUDANTE UNIVERSITARIO", 8),AP("APOSENTADO", 10);

	private final String label;
	private final int lenght;

	PersonType(String label, int lenght) {
		this.label = label;
		this.lenght = lenght;
		
	}
	
}
