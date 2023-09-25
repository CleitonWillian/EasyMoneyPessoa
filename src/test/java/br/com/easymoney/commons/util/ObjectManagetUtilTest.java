package br.com.easymoney.commons.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.dto.inbound.PersonPatchDTO;
import br.com.easymoney.core.enums.PersonType;

public class ObjectManagetUtilTest {

	   @Test
	    @DisplayName("Should copy non-null properties from PersonPatchDTO to PersonDTO")
	    public void shouldCopyProperties() {
	        PersonPatchDTO patchDTO = PersonPatchDTO.builder()
	            .id("1")
	            .name("John")
	            .docIdentifier("123456")
	            .build(); 
	        
	        PersonDTO personDTO = PersonDTO.builder()
	            .id("2")
	            .name("Doe")
	            .docIdentifier("789012")
	            .bornIn(LocalDate.now())
	            .createdAt(LocalDateTime.now())
	            .type(PersonType.PF)
	            .build();

	        ObjectManagerUtil.copy(patchDTO, personDTO);
	        
	        assertThat(personDTO.getId()).isEqualTo(patchDTO.getId());
	        assertThat(personDTO.getName()).isEqualTo(patchDTO.getName());
	        assertThat(personDTO.getDocIdentifier()).isEqualTo(patchDTO.getDocIdentifier());
	    }
}
