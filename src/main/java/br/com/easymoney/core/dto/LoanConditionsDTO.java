package br.com.easymoney.core.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoanConditionsDTO {

	private final BigDecimal minInstallmentAmount;
	
    private final BigDecimal maxTotalAmount;
}
