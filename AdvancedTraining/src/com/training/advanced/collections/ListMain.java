package com.training.advanced.collections;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
	public static void main(final String[] args) {
		// List<String> list = new LinkedList<>();
		List<String> list = new ArrayList<>(2_200_000);
		System.gc();
		long delta = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000; i++) {
			list.add("test" + i);
		}
		System.out.println("Add Delta : " + (System.currentTimeMillis() - delta));

		System.gc();
		// list = new LinkedList<>();
		list = new ArrayList<>(2_200_000);
		delta = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000; i++) {
			list.add("test" + i);
		}
		System.out.println("Add Delta : " + (System.currentTimeMillis() - delta));

		delta = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000; i++) {
			list.get(i);
		}
		System.out.println("Get Delta : " + (System.currentTimeMillis() - delta));

		delta = System.currentTimeMillis();
		for (int i = 0; i < 200_000; i++) {
			list.remove(0);
		}
		System.out.println("Remove Delta : " + (System.currentTimeMillis() - delta));

	}
}
