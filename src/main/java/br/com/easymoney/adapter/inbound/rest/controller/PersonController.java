package br.com.easymoney.adapter.inbound.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.easymoney.adapter.inbound.rest.controller.doc.PersonControllerDoc;
import br.com.easymoney.adapter.inbound.rest.mapper.PersonRestMapper;
import br.com.easymoney.adapter.inbound.rest.request.json.PersonPatchRequestJson;
import br.com.easymoney.adapter.inbound.rest.request.json.PersonSaveRequestJson;
import br.com.easymoney.adapter.inbound.rest.response.json.PersonResponseJson;
import br.com.easymoney.core.dto.PersonFindAllDTO;
import br.com.easymoney.core.port.inbound.PersonPortInbound;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/pessoas")
public class PersonController implements PersonControllerDoc {
	
	private final PersonPortInbound inbound;
	
	private final PersonRestMapper mapper;

	@GetMapping
	public ResponseEntity<Page<PersonResponseJson>> find(Pageable pageable){
		
		var pagePersons = inbound.findAll(new PersonFindAllDTO(pageable));
		
		var pagePersonsResponse = pagePersons.map(mapper::from);
		
		return ResponseEntity.ok(pagePersonsResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonResponseJson> find(@PathVariable String id){
		
		 var person = inbound.findById(id);
		
		 var personResponse = mapper.from(person);
		 
		return ResponseEntity.ok(personResponse);
	}
	
	
	@PostMapping
	public ResponseEntity<PersonResponseJson> create(@Valid @RequestBody PersonSaveRequestJson requestJson){
		
		var person = inbound.create(mapper.from(requestJson));
		
		 var location = ServletUriComponentsBuilder
		            .fromCurrentRequest()
		            .path("/{id}")
		            .buildAndExpand(person.getId())
		            .toUri();
		
		var personResponse = mapper.from(person);
		
		return ResponseEntity.created(location).body(personResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PersonResponseJson> update( @PathVariable String id,@Valid @RequestBody PersonSaveRequestJson requestJson){
		
		var person = inbound.update(mapper.from(id, requestJson));
		
		var personResponse = mapper.from(person);
		
		return ResponseEntity.ok(personResponse);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<PersonResponseJson> patch(@PathVariable String id,@Valid @RequestBody PersonPatchRequestJson requestJson){
		var person = inbound.patch(mapper.from(id, requestJson));
		
		var personResponse = mapper.from(person);
		
		return ResponseEntity.ok(personResponse);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		
		inbound.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
