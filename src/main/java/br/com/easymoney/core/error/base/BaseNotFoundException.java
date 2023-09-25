package br.com.easymoney.core.error.base;

import lombok.Getter;

@Getter
public class BaseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3733353934627968610L;

	private final String title = "Recurso não encontrado";

	public BaseNotFoundException(String string) {
		super(string);
	}

}
