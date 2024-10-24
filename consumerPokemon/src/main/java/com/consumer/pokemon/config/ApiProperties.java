package com.consumer.pokemon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
@ConfigurationProperties
public class ApiProperties {
	
	/**
	 * name uri.
	 */
	@Value("${pokemon.config.name}")
	private String urlName;
	
	/**
	 * name resource.
	 */
	@Value("pokemon.config.url-retive")
	private String resource;
	
}
