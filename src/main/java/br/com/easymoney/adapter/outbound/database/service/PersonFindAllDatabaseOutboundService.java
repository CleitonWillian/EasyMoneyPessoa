package br.com.easymoney.adapter.outbound.database.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.easymoney.adapter.outbound.database.entity.Person;
import br.com.easymoney.adapter.outbound.database.mapper.PersonDatabaseMapper;
import br.com.easymoney.adapter.outbound.database.repository.PersonRepository;
import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.dto.PersonFindAllDTO;
import br.com.easymoney.core.port.outbound.PersonFindAllPortOutbound;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonFindAllDatabaseOutboundService implements PersonFindAllPortOutbound {

	private final PersonRepository repository;
	private final PersonDatabaseMapper mapper;
	
	public Page<PersonDTO> process(PersonFindAllDTO input) {
	
		Page<Person> pageEntity = repository.findAll(input.pageable());
		
		Page<PersonDTO> pagePerson = pageEntity.map(mapper::from);
		
		return pagePerson;
	}

}

;