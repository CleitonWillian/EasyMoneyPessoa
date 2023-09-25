package br.com.easymoney.adapter.inbound.rest.response.json;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(name = "Pessoa")
public class PersonResponseJson {

	@JsonProperty("id")
	@Schema(
		    type = "string", 
		    description = "Um hash padrão SHA-1 para identificar a pessoa no sistema."
		    		+ " Esse id será usado para fazer outras requisições para obter informações do recurso."
		    		+ " Será formado por caracteres numeros e traços, será unico e sempre retornará valor.", 
		    example = "ba2a2b24-4439-486c-8a55-395ffd329722"
		)
	private String id;
	
	@JsonProperty("nome")
	@Schema(
		    type = "string", 
		    description = "Nome da pessoa. Será formado apenas por letras e sempre retornará valor.", 
		    example = "José Augusto"
		)
	private String name;
	
	@JsonProperty("documentoIdentificador")
	@Schema(
		    type = "string", 
		    description = "Documento de Identificação da pessoa. Será formado apenas por numeros e sempre retornará valor.", 
		    example = "12345678"
		)
	private String docIdentifier;
	
	@JsonProperty("nascidoEm")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Schema(
		    type = "string", 
		    description = "Data de nascimento da pessoa. Formato será 'dd-MM-yyyy', por exemplo, '01-01-2022' e sempre retornará valor.", 
		    example = "01-01-2022"
		)
	private LocalDate bornIn; 
	
	@JsonProperty("criadoEm")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Schema(
		    type = "string", 
		    description = "Momento que foi criado essa pessoa. Formato será 'dd-MM-yyyy HH:mm:ss, por exemplo, '01-01-2022 22:22:22' e sempre retornará valor.", 
		    example = "01-01-2022 22:22:22"
		)
	private LocalDateTime createdAt;
	
	@JsonProperty("tipo")
	@Schema(
		    type = "string", 
		    description = "Em qual formato está enquadrado essa pessoa. Poderá ser PESSOA FÍSICA, PESSOA JURÍDICA, ESTUDANTE UNIVERSITÁRIO, APOSENTADO  e sempre retornará valor.", 
		    example = "PESSOA FÍSICA"
		)
	private String type;
	
	
	@JsonProperty("emprestimoCondicoes")
	private LoanConditionsResponseJson loanConditions; 
}
