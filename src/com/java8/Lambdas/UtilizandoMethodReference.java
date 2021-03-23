package com.java8.Lambdas;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class UtilizandoMethodReference {

	public static void main(String[] args) {
		
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
		
		lista.stream()
			// utilizando method reference, referenciando direto o
			// método print
			.forEach(System.out::println);
		
		lista.stream()
		    // sem utilizar
			.forEach((n) -> System.out.println(n) );
		
		System.out.println("-- multiplica sem método de referencia--");
		lista.stream()
			.map( (n) -> multipliquePorDois(n) )
			.forEach(System.out::println);
		
		
		System.out.println("-- multiplica COM método de referencia--");
		lista.stream()
			.map(UtilizandoMethodReference::multipliquePorDois )
			.forEach(System.out::println);
		
		
		// construtores
		System.out.println("Construtor sem utilizar method reference");
		lista.stream()
			.map((n) -> new BigDecimal(n))
			.forEach(System.out::println);
		
		System.out.println("Construtor utilizando method reference");
		lista.stream()
			.map(BigDecimal::new)
			.forEach(System.out::println);
		
		
		System.out.println("instâncias sem utilizar method reference");
		lista.stream()
			.map((n) -> n.doubleValue())
			.forEach(System.out::println);
		
		System.out.println("instâncias utilizando method reference");
		lista.stream()
			.map(Integer::doubleValue)
			.forEach(System.out::println);
		
		
		System.out.println("única instância sem utilizar method reference");
		BigDecimal dois = new BigDecimal(2);
		lista.stream()
			.map(BigDecimal::new)
			.map((b) -> dois.multiply(b))
			.forEach(System.out::println);
		
		System.out.println("única instância utilizando method reference");
		lista.stream()
			.map(BigDecimal::new)
			.map(dois::multiply)
			.forEach(System.out::println);
		
		
	}
	
	private static Integer multipliquePorDois(Integer i) {
		return i * 2;
	}
	
}
