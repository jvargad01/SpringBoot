package com.api.rabbitmq.producer;

import com.api.rabbitmq.model.RetrieveMessage;

public interface SendMessageService {
	
	boolean sendMessage(RetrieveMessage retrieveMessage);
	
}
