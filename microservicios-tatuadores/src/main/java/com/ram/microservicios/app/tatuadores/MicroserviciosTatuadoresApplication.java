package com.ram.microservicios.app.tatuadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.ram.microservicios.commons.tatuadores.models.entity"})
public class MicroserviciosTatuadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosTatuadoresApplication.class, args);
	}

}
