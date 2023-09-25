package br.com.easymoney.adapter.outbound.bussiness;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.dto.LoanConditionsDTO;
import br.com.easymoney.core.enums.PersonType;
import br.com.easymoney.core.port.outbound.PersonLoanConditionsFindPortOutbound;

@Service
public class PersonLoanConditionsFindBussinessOutboundService implements PersonLoanConditionsFindPortOutbound {

	
	private final List<LoanConditionsStrategyEnum> VALUES = List.of(LoanConditionsStrategyEnum.values());
	
	public LoanConditionsDTO process(PersonType input) {
		return VALUES.stream()
				.filter(loanCondition -> loanCondition.name().equals(input.name()))
				.findFirst()
				.map(strategy -> LoanConditionsDTO.builder()
						.minInstallmentAmount(strategy.getMinInstallmentAmount())
						.maxTotalAmount(strategy.getMaxTotalAmount())
						.build())
				.orElseThrow();
	
	}

}
