package com.training.advanced.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.training.advanced.xml.Employee;

@WebService(targetNamespace = "http://hello.adenon.com/cayyapma")
public class MyWebservice {

	@WebMethod(action = "hd", operationName = "helloOp")
	public String hello(@WebParam(name = "name") final String name, @WebParam(name = "surname") final String surname) {
		return "Selam " + name + " " + surname;
	}

	public Employee createEmployee(final Employee employee) {
		employee.setName("ws");
		return employee;
	}
}
