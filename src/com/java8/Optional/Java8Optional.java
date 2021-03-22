package com.java8.Optional;

import java.util.Optional;
import java.util.stream.Stream;

public class Java8Optional {

	public static void main(String[] args) {

		String um = "1";
		Optional<Integer> numero1 = converteEmNumeros(um);
		numero1.ifPresent(e -> System.out.println(e)); 
		// se houver um valor, esse será impresso
		converteEmNumeros(um).ifPresent(e -> System.out.println(e));
		
		// se não der retorno na execução, retorna o 2
		Integer numero2 = converteEmNumeros(um).orElse(2);
		
		Integer numero3 = converteEmNumeros(um)
			//.orElseGet(() -> 2); // se não der certo, retorna o 2s
			.orElseThrow(() -> new NullPointerException("Valor incorreto!"));
		System.out.println(numero3);

		// exemplo chamando direto uma stream
		Stream.of(2, 1, 3)
			.findFirst()
			.ifPresent(System.out::println);
	}

	public static Optional<Integer> converteEmNumeros(String numeroString) {

		try {
			Integer integer = Integer.valueOf(numeroString);
			return Optional.of(integer);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

}
