package com.training.advanced.java;

import java.util.Collection;
import java.util.List;

public class MyCollectHelper<T> {
	private List<T> myList;

	public void accept(final T t, final Integer int1) {
		this.myList.add(t);
	}

	public void acceptAll(final Collection<T> t, final Collection<Integer> intList) {
		this.myList.addAll(t);
	}

}
