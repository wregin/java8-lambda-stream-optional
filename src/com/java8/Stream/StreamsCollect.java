package com.java8.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamsCollect {
	public static void main(String[] args) {
		
		List<Integer> lista = Arrays.asList(1,2,3,4,5,6);
		
		lista.stream()
			.forEach(e -> System.out.println(e));
		
	}
}
