package br.com.easymoney.adapter.outbound.database.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import br.com.easymoney.adapter.outbound.database.entity.base.EntityBase;
import br.com.easymoney.adapter.outbound.database.entity.enums.PersonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity(name = "Pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@SQLDelete(sql = "UPDATE pessoas SET deletado = true WHERE id = ?")
@Where(clause = "deletado = false")
public class Person extends EntityBase {

	@Column(name = "nome", nullable = false)
	private String name;

	@Column(name = "identificador", nullable = false)
	private String docIdentifier;

	@Column(name = "dataNascimento", nullable = false)
	private LocalDate bornIn;

	@Column(name = "tipoIdentificador", nullable = false)
	private PersonType type;

	@Column(name = "valorMinimoMensalDasParcelasDoEmprestimo", nullable = false)
	private BigDecimal minInstallmentLoanAmount ;

	@Column(name = "valorMaximoDeTodoEmprestimo", nullable = false)
	private BigDecimal maxTotalLoanAmount ;

}
