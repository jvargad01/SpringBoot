package com.jv.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
//import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Timed(value = "${message.timed.controller.main}")
public class Controller {

  @PostMapping(value = "${api.retrive}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> retriveCustomer(HttpServletRequest req,
		  @RequestHeader HttpHeaders headers, @RequestBody @Valid RetriveRequest retriveRequest) {
	  
	  return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
