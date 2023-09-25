package br.com.easymoney.adapter.inbound.rest.mapper;

import org.springframework.stereotype.Component;

import br.com.easymoney.adapter.inbound.rest.request.json.PersonPatchRequestJson;
import br.com.easymoney.adapter.inbound.rest.request.json.PersonSaveRequestJson;
import br.com.easymoney.adapter.inbound.rest.response.json.LoanConditionsResponseJson;
import br.com.easymoney.adapter.inbound.rest.response.json.PersonResponseJson;
import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.dto.inbound.PersonCreateDTO;
import br.com.easymoney.core.dto.inbound.PersonPatchDTO;
import br.com.easymoney.core.dto.inbound.PersonUpdateDTO;

@Component
public class PersonRestMapper {

    public PersonResponseJson from(PersonDTO person) {
        return  PersonResponseJson.builder()
                .id(person.getId())
                .name(person.getName())
                .docIdentifier(person.getDocIdentifier())
                .bornIn(person.getBornIn())
                .createdAt(person.getCreatedAt())
                .type(person.getType().getLabel())
                .loanConditions(LoanConditionsResponseJson.builder()
                			.maxTotalAmount(person.getLoanConditionsDTO().getMaxTotalAmount())
                			.minInstallmentAmount(person.getLoanConditionsDTO().getMinInstallmentAmount())
                		.build())
                .build();
    }

    public PersonCreateDTO from(PersonSaveRequestJson requestJson) {
        return new PersonCreateDTO(
            requestJson.getName(),
            requestJson.getDocIdentifier(),
            requestJson.getBornIn()
        );
    }

    public PersonUpdateDTO from(String id, PersonSaveRequestJson requestJson) {
        return PersonUpdateDTO.builder()
            .id(id)
            .name(requestJson.getName())
            .docIdentifier(requestJson.getDocIdentifier())
            .bornIn(requestJson.getBornIn())
            .build();
    }

    public PersonPatchDTO from(String id, PersonPatchRequestJson requestJson) {
    	return PersonPatchDTO.builder()
                .id(id)
                .name(requestJson.getName())
                .docIdentifier(requestJson.getDocIdentifier())
                .bornIn(requestJson.getBornIn())
                .build();
    }

}
