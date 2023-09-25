package br.com.easymoney.adapter.outbound.bussiness;

import java.math.BigDecimal;

import br.com.easymoney.core.enums.PersonType;
import lombok.Getter;

@Getter
public enum LoanConditionsStrategyEnum {

	PF(new BigDecimal(300), new BigDecimal(10000), PersonType.PF),
	PJ(new BigDecimal(1000), new BigDecimal(100000), PersonType.PJ),
	EU(new BigDecimal(100), new BigDecimal(10000), PersonType.EU),
	AP(new BigDecimal(400), new BigDecimal(250000), PersonType.AP);

	private BigDecimal minInstallmentAmount;
	private BigDecimal maxTotalAmount;
	private PersonType personType;

	LoanConditionsStrategyEnum(BigDecimal minInstallmentAmount, BigDecimal maxTotalAmount, PersonType personType) {
		this.minInstallmentAmount = minInstallmentAmount;
		this.maxTotalAmount = maxTotalAmount;
		this.personType = personType;
	}
	
	
}
