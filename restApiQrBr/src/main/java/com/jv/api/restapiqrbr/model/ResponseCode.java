package com.jv.api.restapiqrbr.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCode {
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("width")
	private int width;
	
	@JsonProperty("height")
	private int height;

}
