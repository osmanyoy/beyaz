package com.ms;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyReplyListener {

	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "myqueue2",
	                                                        autoDelete = "false",
	                                                        durable = "true"),
	                                         exchange = @Exchange(name = "myexchange2",
	                                                              durable = "true",
	                                                              type = ExchangeTypes.DIRECT),
	                                         key = "returnback"))

	public void handle(String msg) {
		System.out.println("From bootdemo : " + msg);
	}

}
