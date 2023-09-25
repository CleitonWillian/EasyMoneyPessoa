package br.com.easymoney.adapter.inbound.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class DocumentationConfig implements WebMvcConfigurer {

	@Bean
	OpenAPI restDocConfig() {
		return new OpenAPI()
				.info(new Info()
				.title("Easy Money Pessoa")
	            .version("1.0")
	            .description("API para gerenciamento de pessoas usando arquitetura hexagonal")
	            .contact(new Contact()
	                .name("Cleiton Rocha")
	                .url("https://github.com/CleitonWillian/hexagonal-example")
	                .email("cleiton.devcode@gmail.com"))
	            
	            .license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}
}
