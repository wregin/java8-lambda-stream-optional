package com.java8.Lambdas;

import java.util.stream.IntStream;

public class LambdaOutraFormas {

	public static void main(String[] args) {
		
		// 3 casos onde o parêntese é ncessário
		
		// 1 quando não há argumento: = ()
		Runnable runa = () -> System.out.println("olá");
		
		// 2 e 3
		IntStream.range(0, 5)
			// quando precisa declarar o tipo
			.filter((int n) -> n % 2 == 0)
			// quando tem mais de 1 argumento
			.reduce((n1, n2) -> n1 + n2)
			.ifPresent(System.out::println);
		
		// chaves - Para utilizar precisa do return e ; isso se essa
		// expressão lambda for do tipo que retorna algo
		IntStream.range(0, 5)
			.filter((int n) -> {
				System.out.println("-> " + n);
				return n % 2 == 0;
			})
			.forEach(System.out::println);
		
	}
	
}
