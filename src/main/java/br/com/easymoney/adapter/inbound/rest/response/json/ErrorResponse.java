package br.com.easymoney.adapter.inbound.rest.response.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "RespostaDeErro")
public record ErrorResponse(@JsonProperty("titulo") String title,@JsonProperty("mensagem")  String message) {

}
