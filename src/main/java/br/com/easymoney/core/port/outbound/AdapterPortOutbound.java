package br.com.easymoney.core.port.outbound;

public interface AdapterPortOutbound <R,P>{

	public R process(P input);
}
