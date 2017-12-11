package com.training.advanced.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
	private String str;

	public MyCallable(final String str) {
		super();
		this.str = str;
	}

	@Override
	public String call() throws Exception {
		return this.str.toLowerCase();
	}

}
