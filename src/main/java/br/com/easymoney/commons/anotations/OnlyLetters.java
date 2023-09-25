package br.com.easymoney.commons.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "O campo {fieldName} deve conter apenas letras")
@Constraint(validatedBy = {})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyLetters {
    String message() default "O campo deve conter apenas letras";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
