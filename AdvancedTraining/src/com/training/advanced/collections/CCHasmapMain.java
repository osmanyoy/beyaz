package com.training.advanced.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CCHasmapMain {
	public static void main(final String[] args) {
		Map<String, String> map = new ConcurrentHashMap<>(1_200_000,
		                                                  0.9F,
		                                                  2000);
	}
}
