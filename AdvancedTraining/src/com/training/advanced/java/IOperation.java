package com.training.advanced.java;

@FunctionalInterface
public interface IOperation<T> {
	T execute(T t1, T t2);
}
