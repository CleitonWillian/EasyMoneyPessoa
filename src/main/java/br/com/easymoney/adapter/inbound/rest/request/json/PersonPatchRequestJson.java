package br.com.easymoney.adapter.inbound.rest.request.json;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.easymoney.commons.anotations.OnlyLetters;
import br.com.easymoney.commons.anotations.OnlyNumbers;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(name = "AtualizacaoParcialPessoa")
public class PersonPatchRequestJson {

	@JsonProperty("nome")
	@Schema(
		    type = "string", 
		    description = "O nome pode ser apenas letras ou pode não enviar valor e não pode ser vazio.", 
		    example = "Jose Augusto"
		    
		)
	@OnlyLetters
	private final String name;
	
	@JsonProperty("documentoIdentificador")
	@Schema(
		    type = "string", 
		    description = "O identificador pode ser apenas numeros entre 8 e 14 ou pode não enviar valor e não pode ser vazio.", 
		    example = "12345678"
		    
		)
	@Size( min = 8 ,max = 14)
	@OnlyNumbers
	private final String docIdentifier;
	
	
	@JsonProperty("nascidoEm")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Schema(
		    type = "string", 
		    description = "Data de nascimento. Formato deve ser 'dd-MM-yyyy', por exemplo, '01-01-2022' mas pode não enviar valor e não pode ser vazio..", 
		    example = "01-01-2022"
		)
	private final LocalDate bornIn;
}
