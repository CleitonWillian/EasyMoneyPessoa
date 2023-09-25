package br.com.easymoney.adapter.outbound.database.service;

import org.springframework.stereotype.Service;

import br.com.easymoney.adapter.outbound.database.entity.Person;
import br.com.easymoney.adapter.outbound.database.mapper.PersonDatabaseMapper;
import br.com.easymoney.adapter.outbound.database.repository.PersonRepository;
import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.error.client.PersonNotFoundException;
import br.com.easymoney.core.port.outbound.PersonFindByIdPortOutbound;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonFindByIdDatabaseOutboundService implements PersonFindByIdPortOutbound {

	private final PersonRepository repository;
	private final PersonDatabaseMapper mapper;
	
	public PersonDTO process(String input) {
		
		Person entity = repository.findById(input).orElseThrow(()-> new PersonNotFoundException());
		
		PersonDTO output = mapper.from(entity);
		
		return output;
	}

}

