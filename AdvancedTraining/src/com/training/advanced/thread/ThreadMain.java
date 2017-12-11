package com.training.advanced.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadMain {
	public static void main(final String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(8);
		for (int i = 0; i < 8; i++) {
			MyThread myThread = new MyThread(countDownLatch);
			myThread.start();
		}

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(MyThread.counter2);

	}
}
