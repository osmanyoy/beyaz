package com.training.advanced.thread;

public class MyRunable implements Runnable {

	private static long counter;

	private String str;

	public MyRunable(final String str) {
		super();
		this.str = str;
	}

	@Override
	public void run() {
		System.out.println("Executing : " + MyRunable.counter++ + this.str.toLowerCase());
	}

}
