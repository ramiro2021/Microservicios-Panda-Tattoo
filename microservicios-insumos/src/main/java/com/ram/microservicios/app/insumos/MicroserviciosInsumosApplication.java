package com.ram.microservicios.app.insumos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.ram.microservicios.commons.insumos.models.entity"})
public class MicroserviciosInsumosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosInsumosApplication.class, args);
	}

}
