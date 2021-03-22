package com.java8.Stream;

import java.util.Arrays;
import java.util.List;

public class Parte1StreamsLambda {

	public static void main(String[] args) {
		
		List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
		
		// lembrar que ao utilizar a stream, os valores da lista
		// não serão alterados, mas poderão ser atribuídos em variáveis
		
		// O stream é um fluxo de dados percorrendo o stream
		// há muitas coisas que podem ser feita durante esse fluxo de dados
		lista.stream()
			// para o exemplo o skip faz uma operação intermediária antes da final
			// que é a impressão, então no caso o skip pula os 5 primeiros
			.skip(5)
			.forEach(e -> System.out.println("Skip: " + e));
				
		lista.stream()
			// aqui no caso serão impressos apenas os 6 primeiros
			.limit(6)
			.forEach(e -> System.out.println("Limit: " + e));
		
		lista.stream()
			// para remover valore repetidos, utilizando o equals e hashcode
			// lembrar de implementar na classe medelo se for utilizar
			.distinct()
			.forEach(e -> System.out.println("Distinct: " + e));
		
		lista.stream()
			.skip(2)
			.limit(3)
			.forEach(e -> System.out.println("skip e limit: " + e));
		
		lista.stream()
			.filter(e -> e % 2 == 0)
			.forEach(e -> System.out.println("pares: " + e));
		
		lista.stream()
			.limit(2)
			.map(e -> e * 2)
			.forEach(e -> System.out.println(e));
		
	}

}
