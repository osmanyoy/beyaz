package com.training.advanced.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsMain {
	public static void main(final String[] args) throws IOException {
		List<String> strList = new ArrayList<>();
		strList.add("os1");
		strList.add("os2");
		strList.add("os3");
		strList.add("os437373");
		strList.add("os5");

		for (String string : strList) {
			System.out.println("str : " + string);
		}

		strList.forEach(System.out::println);

		strList.forEach(e -> System.out.println(e));

		System.out.println("-----------------------------------");

		strList.stream()
		       .filter(f -> f.length() < 5)
		       .skip(2)
		       .forEach(System.out::println);

		MyToplam myToplam = new MyToplam();
		Set<Integer> uniqueSayilar = new HashSet<>();
		// Yol 1
		IMyFuncInt funcInt = i1 -> {
			myToplam.setToplam(myToplam.getToplam() + i1);
			return myToplam.getToplam();
		};

		Files.readAllLines(Paths.get("./t.txt"))
		     .stream()
		     .map(s -> Integer.parseInt(s))
		     .forEach(r -> funcInt.toplam(r));

		// Yol 2 fakat sacma
		Files.readAllLines(Paths.get("./t.txt"))
		     .stream()
		     .map(s -> Integer.parseInt(s))
		     .forEach(r -> ((IMyFuncInt) i1 -> {
			     myToplam.setToplam(myToplam.getToplam() + i1);
			     return myToplam.getToplam();
		     }).toplam(r));

		//
		Files.readAllLines(Paths.get("./t.txt"))
		     .stream()
		     .map(s -> Integer.parseInt(s))
		     .forEach(r -> {
			     uniqueSayilar.add(r);
			     myToplam.setToplam(myToplam.getToplam() + r);
		     });

	}
}
