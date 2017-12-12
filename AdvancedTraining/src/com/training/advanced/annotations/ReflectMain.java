package com.training.advanced.annotations;

public class ReflectMain {
	public static void main(final String[] args) throws Exception {
		AnnotationImpl<MyExtendClass> annotationImpl = new AnnotationImpl<>();
		MyExtendClass process = annotationImpl.process(MyExtendClass.class);
		System.out.println("result : " + process.getGtr());
	}
}
