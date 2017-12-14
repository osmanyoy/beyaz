package com.training.advanced.java;

@FunctionalInterface
public interface IToplama {
	int topla(int x, int y);

	default int topDef(final int a, final int b) {
		return a + b;
	}
}
