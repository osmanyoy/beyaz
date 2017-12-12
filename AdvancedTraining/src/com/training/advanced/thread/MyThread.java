package com.training.advanced.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyThread extends Thread {

	public static AtomicLong counter = new AtomicLong();

	public static long counter2 = 0;
	public static long counter3 = 0;

	public static ReentrantLock lock = new ReentrantLock();

	public static ReentrantReadWriteLock lockrw = new ReentrantReadWriteLock();

	private static long counter4;

	public static long read() {
		MyThread.lockrw.readLock()
		               .lock();
		try {
			return MyThread.counter4;
		} finally {
			MyThread.lockrw.readLock()
			               .unlock();
		}

	}

	public static void write() {
		MyThread.lockrw.writeLock()
		               .lock();

		try {
			MyThread.counter4++;
		} finally {
			MyThread.lockrw.writeLock()
			               .unlock();
		}
	}

	public static synchronized long increase() {
		return MyThread.counter2++;
	}

	public static long increase2() {
		MyThread.lock.lock();
		try {
			return MyThread.counter3++;
		} finally {
			MyThread.lock.unlock();
		}
	}

	private CountDownLatch countLatch;

	public MyThread(final CountDownLatch countLatch) {
		super();
		this.countLatch = countLatch;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10_000_000; i++) {
			try {

				// long incrementAndGet = MyThread.increase();
				long incrementAndGet = MyThread.increase2();
				// long incrementAndGet = MyThread.counter.incrementAndGet();
				if ((incrementAndGet % 500_000) == 0) {
					Thread.sleep(1);
				}
				if (this.isInterrupted()) {
					return;
				}
				if (Thread.interrupted()) {

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.countLatch.countDown();
	}
}
