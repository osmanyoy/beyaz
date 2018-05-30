package com.ms;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "myqueue1",
	                                                        autoDelete = "false",
	                                                        durable = "true"),
	                                         exchange = @Exchange(name = "myexchange1",
	                                                              durable = "true",
	                                                              type = ExchangeTypes.DIRECT),
	                                         key = "testkey"))
	@SendTo("myexchange2/returnback")
	public String handle(String msg) {
		System.out.println("Incoming msg : " + msg);
		return "replied " + msg;
	}

}
