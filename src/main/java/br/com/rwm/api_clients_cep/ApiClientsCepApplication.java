package br.com.rwm.api_clients_cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado por Spring Initalizr
 * Módulos:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 * 
 * @author RMWanzo
 */
@EnableFeignClients
@SpringBootApplication
public class ApiClientsCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiClientsCepApplication.class, args);
	}

}
