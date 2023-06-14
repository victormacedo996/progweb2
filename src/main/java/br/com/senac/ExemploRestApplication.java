package br.com.senac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Projeto API",version="2.0",description="Projeto Estudante"))
public class ExemploRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploRestApplication.class, args);
	}

}
