package br.com.easymoney.core.dto.outbound;

import java.time.LocalDate;

import br.com.easymoney.core.enums.PersonType;

public record PersonOldSaveDTO(String name, LocalDate bornIn, PersonType type){

}
