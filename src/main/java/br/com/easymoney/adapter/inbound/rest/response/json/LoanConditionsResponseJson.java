package br.com.easymoney.adapter.inbound.rest.response.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(name = "EmprestimoCondicoes")
public class LoanConditionsResponseJson {

	@JsonProperty("valorMinimoParelas")
	@Schema(
		    type = "float", 
		    description = "Valor mínimo mensal das parcelas do empréstimo.", 
		    example = "300.00"
		)
	private final BigDecimal minInstallmentAmount;
	
	@JsonProperty("valorMaximoTotal")
	@Schema(
		    type = "float", 
		    description = "Valor máximo de todo o empréstimo.", 
		    example = "10000.00"
		)
    private final BigDecimal maxTotalAmount;
}
