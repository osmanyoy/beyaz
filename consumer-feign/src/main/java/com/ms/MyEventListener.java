package com.ms;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

	@EventListener(MyRemoteEvent.class)
	public void handleEvent(MyRemoteEvent myRemoteEvent) {
		System.out.println(myRemoteEvent.getMessage());
	}
}
