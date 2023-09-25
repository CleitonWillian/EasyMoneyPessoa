package br.com.easymoney.core.dto.inbound;

import java.time.LocalDate;

public record PersonCreateDTO(String name, String docIdentifier,LocalDate bornIn){

}
