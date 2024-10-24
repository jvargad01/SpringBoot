package com.api.example.controller.model.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter 
public class RetrieveSelect {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;
  
}
