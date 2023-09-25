package br.com.easymoney.core.port.outbound;

import org.springframework.data.domain.Page;

import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.dto.PersonFindAllDTO;

public interface PersonFindAllPortOutbound extends AdapterPortOutbound<Page<PersonDTO>, PersonFindAllDTO> {

	
	
}
