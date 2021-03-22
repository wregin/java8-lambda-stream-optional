package com.java8.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Parte2StreamsLambda {
	
	public static void main(String[] args) {

		List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
		
		// lembrar que o foreach é operação terminal
		// se tentar chamar depois vai dar erro
		long contador = lista.stream()
			.filter(e -> e % 2 == 0)
			.count();
		
		// aqui nesse exemplo retorna quantos pares tem na lista
		System.out.println(contador);
		
		Optional<Integer> min = lista.stream()
			.filter(e -> e % 2 == 0)
			.min(Comparator.naturalOrder()); // mim ou max
		
		System.out.println("mínimo: " + min.get());
		
		// pegando apenas os pares
		List<Integer> novaLista = lista.stream()
			.filter(e -> e % 2 == 0)
			.collect(Collectors.toList());
		
		System.out.println("apenas os pares: " + novaLista);
		
		// seprando em grupo o par e ímpar
		Map<Boolean, List<Integer>> mapa = lista.stream()
			.map(e -> e * 3)
			.collect(Collectors.groupingBy(e -> e % 2 == 0));
			
		System.out.println("grupo, par é true: " + mapa);
		
		// separando pelo resto da div por 3
		Map<Integer, List<Integer>> mapa2 = lista.stream()
				.collect(Collectors.groupingBy(e -> e % 3));
				
		System.out.println("resto da div por 3 " + mapa2);
		
		// utilizando joining para coletar string
		String coletado = lista.stream()
			.map(e -> String.valueOf(e)) // transformando em string
			.collect(Collectors.joining(", ")); // colocando um separador
		
		System.out.println("String: " + coletado);  
	}
}
