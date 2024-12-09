package com.restapi.InstaAccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "PERSON INSTA ACCOUNT REST API",
	description = "Rest api which has endpoints for performing crud operation on Person and Insta Account table",
	version = "1.0.0",
	contact = @Contact(name = "Manoj",email = "manojshetty5769@gmail.com",url = "https://www.github.com/manojmanu83")))
public class InstaAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstaAccountsApplication.class, args);
	}

}
