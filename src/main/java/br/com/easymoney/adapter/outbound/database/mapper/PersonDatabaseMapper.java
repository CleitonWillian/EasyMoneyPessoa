package br.com.easymoney.adapter.outbound.database.mapper;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.easymoney.adapter.outbound.database.entity.Person;
import br.com.easymoney.adapter.outbound.database.entity.enums.PersonType;
import br.com.easymoney.core.dto.LoanConditionsDTO;
import br.com.easymoney.core.dto.PersonDTO;

@Component
public class PersonDatabaseMapper {

		public PersonDTO from(Person input) {
	        return PersonDTO.builder()
	            .id(input.getId())
	            .name(input.getName())
	            .docIdentifier(input.getDocIdentifier())
	            .bornIn(input.getBornIn())
	            .createdAt(input.getCreatedAt())
	            .type(this.from(input.getType()))
	            .loanConditionsDTO(this.from(input.getMaxTotalLoanAmount(),input.getMinInstallmentLoanAmount()))
	            .build();
	    }

	    private LoanConditionsDTO from(BigDecimal maxTotalLoanAmount, BigDecimal minInstallmentLoanAmount) {
			return LoanConditionsDTO.builder()
						.minInstallmentAmount(minInstallmentLoanAmount)
						.maxTotalAmount(maxTotalLoanAmount)
					.build();
		}

		public Person from(PersonDTO input) {
	      var builder = Person.builder()
	        
	            .name(input.getName())
	            .docIdentifier(input.getDocIdentifier())
	            .bornIn(input.getBornIn())
	            .type(this.from(input.getType()))
	            .minInstallmentLoanAmount(input.getLoanConditionsDTO().getMinInstallmentAmount())
	            .maxTotalLoanAmount(input.getLoanConditionsDTO().getMaxTotalAmount());
	      
			if (input.getId() != null)
				builder.id(input.getId());

			return builder.build();
	      
	           
	    }
	    
	    private PersonType from(br.com.easymoney.core.enums.PersonType type) {
	        return Optional.ofNullable(type)
	                       .map(br.com.easymoney.core.enums.PersonType::name)
	                       .map(PersonType::valueOf)
	                       .orElse(null);
	    }

	    private br.com.easymoney.core.enums.PersonType from(PersonType type) {
	        return Optional.ofNullable(type)
	                       .map(PersonType::name)
	                       .map(br.com.easymoney.core.enums.PersonType::valueOf)
	                       .orElse(null);
	    }
	}







