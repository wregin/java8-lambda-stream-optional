package com.java8.Lambdas;

import java.util.Arrays;
import java.util.List;

public class LambdaDebug {

	public static void main(String[] args) {
		
		// considerar que func lambda deveria ser pequena
		// então se estiver grande e tiver que debugar pode ser trabalhoso
		
		List<Integer> lista = Arrays.asList(1, 2, 5, 8, 9);
		
		lista.stream()
			.map((n) -> new StringBuffer().append(n).append("s").append("a"))
			.forEach(System.out::println);
		
		// para debugar abaixo é mais fácil que acima, dividindo
		lista.stream()
		.map((n) -> {
			StringBuilder build = new StringBuilder();
			build.append(n);
			build.append("s");
			build.append("a");
			return build;
		})
		.forEach(System.out::println);
		
		// outra forma ainda é separar num método
		lista.stream()
		// peek pode ajudar no debug/log
		// abrir a declaracao para saber mais
		.peek(n -> System.out.println(n + " opa"))
		.filter(n -> n % 2 == 0)
		.peek(n -> System.out.println(n + " ixi"))
		.map((n) -> converteParaStringBuilder(n))
		.forEach(System.out::println);
		
		
	}

	private static StringBuilder converteParaStringBuilder(Integer n) {
		StringBuilder build = new StringBuilder();
		build.append(n);
		build.append("s");
		build.append("a");
		return build;
	}
	
}
