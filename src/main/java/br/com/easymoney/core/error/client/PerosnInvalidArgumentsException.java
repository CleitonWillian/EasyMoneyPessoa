package br.com.easymoney.core.error.client;

import br.com.easymoney.core.error.base.BaseInvalidArgumentsException;

public class PerosnInvalidArgumentsException extends BaseInvalidArgumentsException{

	private static final long serialVersionUID = -232921048468061972L;

	public PerosnInvalidArgumentsException() {
		super("Argumentos invalidos para pessoa");
	}
	
}
