package br.com.easymoney.core.dto.inbound;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonPatchDTO {

	private String id;
	private String name;
	private String docIdentifier;
	private LocalDate bornIn;
	
	
}
