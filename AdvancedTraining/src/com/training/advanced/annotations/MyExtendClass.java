package com.training.advanced.annotations;

public class MyExtendClass extends MyRootClass {

	@MyFirstAnnotation(name = "osman")
	private String gtr;

	@Override
	public String helloMello() {
		// TODO Auto-generated method stub
		return "test";
	}

	public void name(final String str) {
		this.setGtr(str);
	}

	public String getGtr() {
		return this.gtr;
	}

	public void setGtr(final String gtr) {
		this.gtr = gtr;
	}

}
