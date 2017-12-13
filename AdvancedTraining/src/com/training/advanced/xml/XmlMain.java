package com.training.advanced.xml;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlMain {

	public static void main(final String[] args) throws JAXBException {
		String string = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><employee><coins>0</coins><name>osman</name><phone>d7763</phone><surname>yay</surname></employee>";
		JAXBContext newInstance = JAXBContext.newInstance(Employee.class);
		Marshaller createMarshaller = newInstance.createMarshaller();

		Employee employee = Employee.getBuilder()
		                            .setName("osman")
		                            .setSurname("yay")
		                            .setPhone("d7763")
		                            .build();

		createMarshaller.marshal(employee,
		                         System.out);

		Unmarshaller createUnmarshaller = newInstance.createUnmarshaller();
		StringReader reader = new StringReader(string);
		Object unmarshal = createUnmarshaller.unmarshal(reader);
		Employee employee2 = (Employee) unmarshal;
		System.out.println(employee2);
	}

}
