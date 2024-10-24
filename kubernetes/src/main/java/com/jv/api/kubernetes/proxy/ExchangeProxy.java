package com.jv.api.kubernetes.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jv.api.kubernetes.dto.Conversion;

//@FeignClient(name="currency-exchange", url="localhost:8000")
//@FeignClient(name="currency-exchange")

//CHANGE-KUBERNETES
@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
//@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8000")
public interface ExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public Conversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);
	
}
