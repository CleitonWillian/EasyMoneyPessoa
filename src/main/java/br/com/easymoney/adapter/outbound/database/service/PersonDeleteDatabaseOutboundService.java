package br.com.easymoney.adapter.outbound.database.service;

import org.springframework.stereotype.Service;

import br.com.easymoney.adapter.outbound.database.repository.PersonRepository;
import br.com.easymoney.core.port.outbound.PersonDeletePortOutbound;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonDeleteDatabaseOutboundService implements PersonDeletePortOutbound {

	private final PersonRepository repository;
	
	public Void process(String input) {
		
		 repository.deleteById(input);
		
		 return null;
		
		
		
	}

}

