package com.consumer.pokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPokemon {

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;
	
}
