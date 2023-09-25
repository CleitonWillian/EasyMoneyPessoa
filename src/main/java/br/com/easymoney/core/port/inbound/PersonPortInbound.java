package br.com.easymoney.core.port.inbound;

import org.springframework.data.domain.Page;

import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.dto.PersonFindAllDTO;
import br.com.easymoney.core.dto.inbound.PersonCreateDTO;
import br.com.easymoney.core.dto.inbound.PersonPatchDTO;
import br.com.easymoney.core.dto.inbound.PersonUpdateDTO;

public interface PersonPortInbound {

	public Page<PersonDTO> findAll(PersonFindAllDTO input);
	public PersonDTO findById(String input);
	public PersonDTO create(PersonCreateDTO input);
	public PersonDTO update(PersonUpdateDTO input);
	public PersonDTO patch(PersonPatchDTO input);
	public void delete(String input);
	
}
