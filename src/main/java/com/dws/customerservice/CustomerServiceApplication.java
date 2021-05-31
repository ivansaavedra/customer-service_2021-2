package com.dws.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	
	/** Con este metodo se limita las direcciones de clientes que pueden acceder a los servicios que ofrece esta aplicacion
	 *  y los metodos que son validos para interactuar con la misma. Los metodos de acceso se pueden redefinir en metodos especificos.  
	 */
	
	/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("POST", "PUT", "GET", "PATCH", "DELETE");
			}
		};
	}
	*/

}
