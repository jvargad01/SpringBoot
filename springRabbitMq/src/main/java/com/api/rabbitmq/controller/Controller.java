package com.api.rabbitmq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
 
import com.api.rabbitmq.model.RetrieveMessage;

@RestController
public class Controller {

	
	@PostMapping(value = "/api/sendMessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> retrieve(HttpServletRequest req,
			@RequestHeader HttpHeaders headers, 
			@RequestBody RetrieveMessage retrieve){
		 
		String response  = "test OK";
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
