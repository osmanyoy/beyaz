package com.training.advanced.java.after;

import java.util.function.Predicate;

import com.training.advanced.java.before.ICompare;

public class CompareAfterMain {
	public static void main(final String[] args) {
		ICompare compare1 = (x, y) -> x > y;
		System.out.println("Bigger result : " + compare1.compare(30,
		                                                         20));
		ICompare compare2 = (x, y) -> x == y;

		System.out.println("Equal result : " + compare2.compare(30,
		                                                        20));

		ICompare compare3 = (x, y) -> x < y;

		System.out.println("Less result : " + compare3.compare(30,
		                                                       20));
		ICompare compare4 = (x, y) -> (x / 2) > y;

		Predicate<String> strPred = (s) -> s.length() > 5;
		strPred.and((s) -> s.length() < 10)
		       .or((z) -> z.equals("osm"));

		boolean test = strPred.test("ewuwe");
	}
}
