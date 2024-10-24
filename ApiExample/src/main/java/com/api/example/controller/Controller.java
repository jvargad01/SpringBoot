package com.api.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.api.example.controller.model.req.RetrieveSelect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Controller {
	 
	@Value("${value.test.retieve}")
	private String valor;
	
	@PostMapping(value = "/api/retrieve", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> retrieve(HttpServletRequest req,
			@RequestHeader HttpHeaders headers, 
			@RequestBody RetrieveSelect retrieve){
		
		log.info(" test: {}. ", retrieve);
		String response  = "test OK";
		log.info("Test: {}", valor);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
