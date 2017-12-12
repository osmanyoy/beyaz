package com.training.advanced.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StreamMain {
	public static void main(final String[] args) {
		File file = new File("myfile.txt");
		try (FileInputStream fileInputStream = new FileInputStream(file);
		        FileReader fileReader = new FileReader(file)) {
			Set<String> strings = new HashSet<>();
			Collection<String> synchronizedCollection = Collections.synchronizedCollection(strings);

			Collections.synchronizedSet(null);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			char[] cbuf = new char[1024 * 1024 * 1000];
			bufferedReader.read(cbuf);

			byte[] buffer = new byte[1024];
			int read = fileInputStream.read(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
