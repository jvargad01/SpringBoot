package com.consumer.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerPokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerPokemonApplication.class, args);
	}

}
