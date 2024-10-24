package com.api.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter 
public class RetrieveMessage {

	@JsonProperty("message")
	private String message;
	
}
