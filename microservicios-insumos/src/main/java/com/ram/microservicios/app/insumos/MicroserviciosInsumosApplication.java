package com.ram.microservicios.app.insumos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosInsumosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosInsumosApplication.class, args);
	}

}
