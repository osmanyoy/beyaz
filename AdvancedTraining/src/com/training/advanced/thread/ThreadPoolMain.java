package com.training.advanced.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {
	public static void main(final String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			newFixedThreadPool.execute(new MyRunable("TEST str " + i));
		}
	}
}
