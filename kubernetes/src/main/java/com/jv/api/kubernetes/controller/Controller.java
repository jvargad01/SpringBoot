package com.jv.api.kubernetes.controller;


import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jv.api.kubernetes.dto.Conversion;
import com.jv.api.kubernetes.proxy.ExchangeProxy;
 

@RestController
public class Controller {
	
    private Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private ExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public Conversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		//CHANGE-KUBERNETES
		logger.info("calculateCurrencyConversion called with {} to {} with {}", from, to, quantity);
		
		HashMap<String, String> uriVariables = new HashMap();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		
		ResponseEntity<Conversion> responseEntity = new RestTemplate().getForEntity
		("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				Conversion.class, uriVariables);
		
		Conversion currencyConversion = responseEntity.getBody();
		
		return new Conversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment()+ " " + "rest template");
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public Conversion calculateCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
				
		//CHANGE-n
		logger.info("calculateCurrencyConversionFeign called with {} to {} with {}", from, to, quantity);

		Conversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		return new Conversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment() + " " + "feign");
		
	}
}
