package com.dws.customerservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
<<<<<<< HEAD

=======
	
>>>>>>> d8727bcd0371e3952633f7234da9dccc9fcead27
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dws.customerservice.controller"))
				.paths(PathSelectors.any())
				.build()
<<<<<<< HEAD
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API WS UNAM",
				"Solicityud de API WS UNAM",
				"1.0",
				"http://localhost:8080",
				new Contact("WS", "http://localhost:8080", "ivan.saavedra@ciencias.unam.mx"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
}
=======
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API WS UNAM",
				"Ejemplo de configuracion de Documentacion con Swagger",
				"1.0",
				"http://localhost:8080/terminos",
				new Contact("Ivan Saavedran", "http://localhost:8080", "ivan.saavedra@ciencias.unam.mx"),
				"Licencia",
				"http://localhost:8080",
				Collections.emptyList());
	}	

}
>>>>>>> d8727bcd0371e3952633f7234da9dccc9fcead27
