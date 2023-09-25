package br.com.easymoney.core.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.easymoney.commons.util.ObjectManagerUtil;
import br.com.easymoney.core.dto.LoanConditionsDTO;
import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.dto.PersonFindAllDTO;
import br.com.easymoney.core.dto.inbound.PersonCreateDTO;
import br.com.easymoney.core.dto.inbound.PersonPatchDTO;
import br.com.easymoney.core.dto.inbound.PersonUpdateDTO;
import br.com.easymoney.core.enums.PersonType;
import br.com.easymoney.core.port.inbound.PersonPortInbound;
import br.com.easymoney.core.port.outbound.PersonCreatePortOutbound;
import br.com.easymoney.core.port.outbound.PersonDeletePortOutbound;
import br.com.easymoney.core.port.outbound.PersonFindAllPortOutbound;
import br.com.easymoney.core.port.outbound.PersonFindByIdPortOutbound;
import br.com.easymoney.core.port.outbound.PersonLoanConditionsFindPortOutbound;
import br.com.easymoney.core.port.outbound.PersonTypeFindPortOutbound;
import br.com.easymoney.core.port.outbound.PersonUpdatePortOutbound;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonPortInboundService implements PersonPortInbound {

	private final PersonFindAllPortOutbound findAllPortOutbound;
	private final PersonFindByIdPortOutbound findByIdPortOutbound;
	private final PersonCreatePortOutbound createPortOutbound;
	private final PersonUpdatePortOutbound updatePortOutbound;
	private final PersonDeletePortOutbound deletePortOutbound;
	private final PersonTypeFindPortOutbound typeFindPortOutbound;
	private final PersonLoanConditionsFindPortOutbound loanConditionsFindPortOutbound;

	public Page<PersonDTO> findAll(PersonFindAllDTO input) {

		Page<PersonDTO> process = findAllPortOutbound.process(input);

		return process;
	}

	public PersonDTO findById(String input) {
		PersonDTO process = findByIdPortOutbound.process(input);

		return process;
	}

	public PersonDTO create(PersonCreateDTO input) {
		
		var type = typeFindPortOutbound.process(input.docIdentifier());
		
		var loanConditions = loanConditionsFindPortOutbound.process(type);

		var processedPerson = createPortOutbound.process(buildPersonWithTypeAndLoanConditions(input, type, loanConditions));
		
		return processedPerson;
	}



	public PersonDTO update(PersonUpdateDTO input) {
		PersonDTO person = findByIdPortOutbound.process(input.getId());
		
		ObjectManagerUtil.copy(input, person);
		
		person = buildLoanConditionsAndPersonTypeInPerson(input.getDocIdentifier(), person);
		
		PersonDTO processedPerson = updatePortOutbound.process(person);
		
		return processedPerson;
	}



	public PersonDTO patch(PersonPatchDTO input) {

		PersonDTO person = findByIdPortOutbound.process(input.getId());

		ObjectManagerUtil.copy(input, person);

		if (input.getDocIdentifier() != null) {
			person = buildLoanConditionsAndPersonTypeInPerson(input.getDocIdentifier(), person);
		}

		PersonDTO processedPerson = updatePortOutbound.process(person);

		return processedPerson;
	}

	public void delete(String input) {
		deletePortOutbound.process(input);

	}

	
	
	
	private PersonDTO buildPersonWithTypeAndLoanConditions(PersonCreateDTO input, PersonType type, LoanConditionsDTO loanConditions) {
		return PersonDTO.builder()
				.name(input.name())
				.bornIn(input.bornIn())
				.docIdentifier(input.docIdentifier())
				.type(type)
				.loanConditionsDTO(loanConditions)
				.build();
	}
	
	private PersonDTO buildLoanConditionsAndPersonTypeInPerson(String docIdentifier, PersonDTO person) {
		
		PersonType type = typeFindPortOutbound.process(docIdentifier);
		
		LoanConditionsDTO loanConditions = loanConditionsFindPortOutbound.process(type);
		
		person = person.withType(type).withLoanConditionsDTO(loanConditions);
		
		return person;
	}

}
