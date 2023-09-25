package br.com.easymoney.adapter.inbound.rest.controller.doc;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.com.easymoney.adapter.inbound.rest.request.json.PersonPatchRequestJson;
import br.com.easymoney.adapter.inbound.rest.request.json.PersonSaveRequestJson;
import br.com.easymoney.adapter.inbound.rest.response.json.ErrorResponse;
import br.com.easymoney.adapter.inbound.rest.response.json.PersonResponseJson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Person API", description = "API para gerenciamento de pessoas (CRUD)")
public interface PersonControllerDoc {

	@Operation(summary = "Listar todas as pessoas", description = "Retorna uma lista paginável de pessoas")
	ResponseEntity<Page<PersonResponseJson>> find(
			@Parameter(name = "Informações para paginação", description = "Configurações de paginação")
			Pageable pageable);

	@Operation(summary = "Buscar uma pessoa por ID", responses = {
			@ApiResponse(responseCode = "200", description = "Pessoa encontrada", content = @Content(schema = @Schema(implementation = PersonResponseJson.class))),
			@ApiResponse(responseCode = "400", description = "Argumento invalido",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Pessoa não encontrada",content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<PersonResponseJson> find(@Parameter(description = "ID da pessoa") String id);

	@Operation(summary = "Criar uma nova pessoa", responses = {
			@ApiResponse(responseCode = "201", description = "Pessoa encontrada", content = @Content(schema = @Schema(implementation = PersonResponseJson.class))),
			@ApiResponse(responseCode = "400", description = "Argumento invalido",content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<PersonResponseJson> create(
			@Parameter(description = "Objeto pessoa para criar nova pessoa", required = true) PersonSaveRequestJson requestJson);

	@Operation(summary = "Atualizar uma pessoa existente por ID", responses = {
			@ApiResponse(responseCode = "200", description = "Pessoa atualizada completa", content = @Content(schema = @Schema(implementation = PersonResponseJson.class))),
			@ApiResponse(responseCode = "400", description = "Argumento invalido",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Pessoa não encontrada para atualizar",content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<PersonResponseJson> update(@Parameter(description = "ID da pessoa") String id,
			@Parameter(description = "Objeto pessoa para atualizar pessoa existente", required = true) PersonSaveRequestJson requestJson);

	@Operation(summary = "Atualizar parcialmente uma pessoa existente por ID", responses = {
			@ApiResponse(responseCode = "200", description = "Pessoa encontrada parial", content = @Content(schema = @Schema(implementation = PersonResponseJson.class))),
			@ApiResponse(responseCode = "400", description = "Argumento invalido",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Pessoa não encontrada para atualizar",content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<PersonResponseJson> patch(@Parameter(description = "ID da pessoa") String id,
			@Parameter(description = "Objeto para atualizar parcialmente uma pessoa", required = true) PersonPatchRequestJson requestJson);

	@Operation(summary = "Excluir uma pessoa por ID", responses = {
			@ApiResponse(responseCode = "204", description = "Pessoa excluida", content = @Content(schema = @Schema(implementation = PersonResponseJson.class))),
			@ApiResponse(responseCode = "400", description = "Argumento invalido",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Pessoa não encontrada para excluir",content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<Void> delete(@Parameter(description = "ID da pessoa") String id);

}
