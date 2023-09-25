package br.com.easymoney.adapter.outbound.database.service;

import org.springframework.stereotype.Service;

import br.com.easymoney.adapter.outbound.database.entity.Person;
import br.com.easymoney.adapter.outbound.database.mapper.PersonDatabaseMapper;
import br.com.easymoney.adapter.outbound.database.repository.PersonRepository;
import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.port.outbound.PersonCreatePortOutbound;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonCreateDatabasetOutboundService implements PersonCreatePortOutbound {

	private final PersonRepository repository;
	private final PersonDatabaseMapper mapper;
	
	public PersonDTO process(PersonDTO input) {
		
		Person entity = mapper.from(input);
		
		Person savedEntity = repository.save(entity);
		
		PersonDTO output = mapper.from(savedEntity);
		
		return output;
	}

}

