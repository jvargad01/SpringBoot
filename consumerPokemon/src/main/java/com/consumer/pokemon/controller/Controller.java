package com.consumer.pokemon.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.pokemon.client.ClientPokemon;
import com.consumer.pokemon.model.RequestPokemon;

import javax.validation.Valid;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Timed(value = "${message.timed.controller.main}")
public class Controller {
	
	@Autowired
	private ClientPokemon clientPokemon;

	@PostMapping(value = "${api.retrive}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> retrivePokemon(HttpServletRequest req,
			  @RequestHeader HttpHeaders headers, @RequestBody @Valid RequestPokemon retriveRequest) {
		
		String response = "";
		
		JSONObject json = clientPokemon.getDataPokemon(retriveRequest.getName());

		
		log.info("Mesagge {}", json.toString());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
