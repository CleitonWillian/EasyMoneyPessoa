package br.com.easymoney.core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.easymoney.core.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.With;

@AllArgsConstructor
@Getter
@Setter
@With
@Builder
public class PersonDTO{

	
	private String id;
	private String name;
	private String docIdentifier;
	private LocalDate bornIn;
	private LocalDateTime createdAt;
	private PersonType type;
	private LoanConditionsDTO loanConditionsDTO;

	
}
