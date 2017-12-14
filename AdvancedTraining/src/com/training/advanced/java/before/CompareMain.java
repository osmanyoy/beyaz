package com.training.advanced.java.before;

public class CompareMain {
	public static void main(final String[] args) {
		ICompare compare1 = new CompareBiggerImpl();
		System.out.println("Bigger result : " + compare1.compare(30,
		                                                         20));

		ICompare compare2 = new CompareEqualImpl();
		System.out.println("Equal result : " + compare2.compare(30,
		                                                        20));

		ICompare compare3 = new CompareLessThanImpl();
		System.out.println("Less result : " + compare3.compare(30,
		                                                       20));

		ICompare compare4 = new ICompare() {

			@Override
			public boolean compare(final int x, final int y) {
				return (x / 2) > y;
			}
		};
		System.out.println("Less result : " + compare4.compare(30,
		                                                       20));

	}
}
