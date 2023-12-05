package com.ai.clientdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ClientDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientDataServiceApplication.class, args);
	}

}
