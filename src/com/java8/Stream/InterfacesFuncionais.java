package com.java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class InterfacesFuncionais {
	
	public static void main(String[] args) {
		
		// supplier
		// não recebe dado, mas retorna um
		Stream.generate(() -> new Random().nextInt())
			.limit(5)
			// consumer = recebe valor mas não retorna
			.forEach(System.out::println);
		
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
		
		lista.stream()
			// predicate = um teste/compara ao receber o valor e retorna
			.filter(e -> e % 2 == 0)      
			// function = recebe um valor e retorna outro
			.map(e -> e.doubleValue())    
			// BinaryOperator = recebe um e retorna outro do mesmo tipo
			.reduce((e1, e2) -> e1 + e2)  
			//.forEach(System.out::println);
			.ifPresent(System.out::println);
		
	}
}
