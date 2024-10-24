package com.jv.api.restapiqrbr.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jv.api.restapiqrbr.model.RequestCode;
import com.jv.api.restapiqrbr.service.ServiceGenerator;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/api/v1/domain/services/generator/code")
public class Controller {
	
	@Autowired
	private ServiceGenerator service;
	
	@RequestMapping(value = "/qr", headers = "Accept=image/jpeg, image/jpg, image/png, image/gif",
			method=RequestMethod.GET)
	public void retriveColaborators(HttpServletResponse response,
			@RequestHeader HttpHeaders header,
			@RequestBody RequestCode request){
		
		log.info("datos {}", request.getText());
		BufferedImage images = service.generateQRCode(request);
		 
		 
		
	}
}
