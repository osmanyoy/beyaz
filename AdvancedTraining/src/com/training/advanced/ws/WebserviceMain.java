package com.training.advanced.ws;

import javax.xml.ws.Endpoint;

public class WebserviceMain {
	public static void main(final String[] args) {
		Endpoint.publish("http://localhost:7070/myws",
		                 new MyWebservice());
	}
}
