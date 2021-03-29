package com.java8.Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CriandoStreams {

	public static void main(String[] args) throws IOException {
		
		// Collection
		List<Integer> lista = Arrays.asList(1, 2, 3, 4);
		lista.stream().forEach(System.out::println);
		
		// Arrays
		Integer[] intArray = new Integer[] {1, 2, 3, 4};
		Arrays.stream(intArray).forEach(System.out::println);
		
		// Stream.of
		Stream
			.of("Opa", "como", "vai", "você", "hoje")
			.forEach(System.out::println);
		
		// IntStream.range
		IntStream.range(12, 17).forEach(System.out::println);
		
		// Stream.iterate
		Stream
			.iterate(5, n -> n * 2)
			.limit(10)
			.forEach(System.out::println);
		
		// BufferedReader  - lines
		File file = new File("streams.txt");
		FileReader in = new FileReader(file);
		try (BufferedReader br = new BufferedReader(in) ) {
			br.lines().forEach(System.out::println);
		}
		
		// files
		Path p = Paths.get("");
		Files.list(p).forEach(System.out::println);
		
		// random
		new Random()
			.ints()
			.limit(2)
			.forEach(System.out::println);
		
		// pattern
		String s = "Opa como vai você";
		Pattern pa = Pattern.compile(" ");
		pa.splitAsStream(s).forEach(System.out::println);
		
		
	}
}
