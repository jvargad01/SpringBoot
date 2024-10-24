package com.api.rabbitmq.confing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class RabbitMqProperties {
	@Value("${rmq.data.channel.name}")
	private String channeldemo;

	@Value("${rmq.data.routing.key}") 
	private String routing_key;

	@Value("${rmq.data.queue.name}")
	private String namequeue;

	@Value("${rmq.data.isdurable.queue}")
	private boolean isdurable;
	
	@Value("${rmq.data.receive.message}")
    private String messageReceive;
	

}
