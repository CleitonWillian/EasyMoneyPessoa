package br.com.easymoney.core.error.client;

import br.com.easymoney.core.error.base.BaseInvalidArgumentsException;

public class PersonTypeInvalidException extends BaseInvalidArgumentsException {

	private static final long serialVersionUID = -5827957304054524392L;

	public PersonTypeInvalidException() {
		super("Tipo invalido, não foi encontrado para esse modelo de documento");
	}

}
