package br.com.easymoney.core.error.client;

import br.com.easymoney.core.error.base.BaseNotFoundException;

public class PersonNotFoundException extends BaseNotFoundException{

	private static final long serialVersionUID = 1147893121426577593L;

	public PersonNotFoundException() {
		super("Essa Pessoa não foi encontrada em nossa base de dados");
	}
}
