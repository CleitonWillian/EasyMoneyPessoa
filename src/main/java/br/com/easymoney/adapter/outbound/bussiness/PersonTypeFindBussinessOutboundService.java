package br.com.easymoney.adapter.outbound.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.enums.PersonType;
import br.com.easymoney.core.port.outbound.PersonTypeFindPortOutbound;

@Service
public class PersonTypeFindBussinessOutboundService implements PersonTypeFindPortOutbound {

	private static final List<PersonType> VALUES = List.of(PersonType.values());
	
	public PersonType process(String input) {
		
		int lenght = Optional.of(input).map(String::length).orElseThrow();
		
		PersonType typeFound = VALUES.stream().filter(type -> type.getLenght() == lenght).findFirst().orElseThrow();
		
		return typeFound;
	}

}
