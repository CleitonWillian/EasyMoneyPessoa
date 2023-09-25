package br.com.easymoney.adapter.inbound.rest.controller.advice;

import static java.lang.System.lineSeparator;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.easymoney.adapter.inbound.rest.response.json.ErrorResponse;
import br.com.easymoney.core.error.base.BaseInvalidArgumentsException;
import br.com.easymoney.core.error.base.BaseNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ExceptionControllerAdvice {

	@ExceptionHandler(BaseInvalidArgumentsException.class)
	public ResponseEntity<ErrorResponse> handle(BaseInvalidArgumentsException ex){
		return new ResponseEntity<>(new ErrorResponse(ex.getTitle(),ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BaseNotFoundException.class)
	public ResponseEntity<ErrorResponse> handle(BaseNotFoundException ex){
		return new ResponseEntity<>(new ErrorResponse(ex.getTitle(),ex.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException ex) {
		   Class<?> clazz = ex.getBindingResult().getTarget().getClass();
	        
	        var errorMessages = ex.getBindingResult().getFieldErrors().stream()
	            .map(fieldError -> {
	                String fieldName = fieldError.getField();
	                String defaultMessage = fieldError.getDefaultMessage();

	                try {
	                    Field field = clazz.getDeclaredField(fieldName);
	                    JsonProperty jsonProperty = AnnotationUtils.getAnnotation(field, JsonProperty.class);
	                    if (jsonProperty != null) {
	                        fieldName = jsonProperty.value();
	                    }
	                } catch (NoSuchFieldException e) {
	                    // Ignorar, usar o nome do campo como está
	                }

	                return "(" + fieldName + "): " + defaultMessage + ". ";
	            })
	            .toList();

		return new ResponseEntity<>(
				new ErrorResponse("Erro de validação", StringUtils.join(errorMessages, lineSeparator())),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PropertyReferenceException.class)
	public ResponseEntity<ErrorResponse> handle(PropertyReferenceException ex) {
		return new ResponseEntity<>(new ErrorResponse("Propriedade Inválida para busca.", ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handle(Exception ex) {
		log.error("Erro inesperado não tratado", ex);
		return new ResponseEntity<>(new ErrorResponse("Erro inesperado", ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
