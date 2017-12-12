package com.training.advanced.annotations;

import java.lang.reflect.Field;

public class AnnotationImpl<T> {
	public T process(final Class<T> myClass) throws Exception {
		T newInstance = myClass.newInstance();
		Field[] declaredFields = myClass.getDeclaredFields();
		for (Field field : declaredFields) {
			MyFirstAnnotation annotation = field.getAnnotation(MyFirstAnnotation.class);
			if (annotation != null) {
				String name = annotation.name();
				field.setAccessible(true);
				field.set(newInstance,
				          name);
			}
		}
		return newInstance;
	}
}
