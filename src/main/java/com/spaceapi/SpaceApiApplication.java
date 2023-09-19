package com.spaceapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Space API", version = "1.0", description = "Api of a service of streaming"))
@SpringBootApplication
public class SpaceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceApiApplication.class, args);
	}

}
