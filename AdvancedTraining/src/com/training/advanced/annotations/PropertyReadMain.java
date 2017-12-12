package com.training.advanced.annotations;

public class PropertyReadMain {

	public static void main(final String[] args) throws Exception {

		// File file = new File("my.properties");
		// FileInputStream inStream = new FileInputStream(file);
		// Properties properties = new Properties();
		// properties.load(inStream);
		//
		// MyPropObj myPropObj = new MyPropObj();
		//
		// String property = properties.getProperty("my.port");
		// int parseInt = Integer.parseInt(property);
		// myPropObj.setPort(parseInt);

		PropertyReader<MyPropObj> propertyReader = new PropertyReader<>();
		MyPropObj readProperty = propertyReader.readProperty(MyPropObj.class);
		System.err.println("Read :" + readProperty);

	}

}
