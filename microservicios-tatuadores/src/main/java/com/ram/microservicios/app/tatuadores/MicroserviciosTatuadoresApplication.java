package com.ram.microservicios.app.tatuadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosTatuadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosTatuadoresApplication.class, args);
	}

}
