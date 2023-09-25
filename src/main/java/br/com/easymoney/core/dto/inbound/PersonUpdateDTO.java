package br.com.easymoney.core.dto.inbound;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PersonUpdateDTO {

	private String id;
	private String name;
	private String docIdentifier;
	private LocalDate bornIn;

	
}
