package com.training.advanced.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolMain {
	public static void main(final String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			newFixedThreadPool.execute(new MyRunable("TEST str " + i));
		}

		List<Future<String>> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Future<String> result = newFixedThreadPool.submit(new MyCallable("TEST str " + i));
			list.add(result);
		}
		try {
			for (Future<String> future : list) {
				String string = future.get();
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
