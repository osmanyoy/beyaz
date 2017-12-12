package com.training.advanced.annotations;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropertyReader<T> {
	public T readProperty(final Class<T> myClass) throws Exception {
		PropertyFile fileAnno = myClass.getAnnotation(PropertyFile.class);
		if (fileAnno == null) {
			return null;
		}
		String fileName = fileAnno.value();

		File file = new File(fileName);
		FileInputStream inStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(inStream);

		T newInstance = myClass.newInstance();

		Field[] declaredFields = myClass.getDeclaredFields();
		for (Field field : declaredFields) {
			Property annotation = field.getAnnotation(Property.class);
			if (annotation != null) {
				String key = annotation.key();
				field.setAccessible(true);

				String propertyVal = properties.getProperty(key);
				if (propertyVal != null) {
					Class<?> type = field.getType();
					if (type.getName()
					        .equals("java.lang.String")) {
						field.set(newInstance,
						          propertyVal);

					} else if (type.getName()
					               .equals("int")) {
						field.setInt(newInstance,
						             Integer.parseInt(propertyVal));

					} else if (type.getName()
					               .equals("double")) {
						field.setDouble(newInstance,
						                Double.parseDouble(propertyVal));
					} else if (type.getName()
					               .equals("long")) {
						field.setLong(newInstance,
						              Long.parseLong(propertyVal));
					}

				}
			}
		}
		return newInstance;

	}
}
