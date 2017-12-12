package com.training.advanced.annotations;

import java.security.acl.NotOwnerException;

public class Runner {
	public static void main(String[] args) {
		MyRootClass class1 = new MyExtendClass();
		class1.helloMello();
	}
}
