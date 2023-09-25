package br.com.easymoney.core.error.base;

import lombok.Getter;

@Getter 
public class BaseInvalidArgumentsException  extends RuntimeException{

	private static final long serialVersionUID = 4929885780908065431L;

	private final String title = "Argumento inválido";

	public BaseInvalidArgumentsException(String string) {
		super(string);
	
	}

}
