package com.java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsParapelos {

	public static void main(String[] args) {
		
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		// exemplo 1 paralelo e não ordenado
		// várias threads trabalhando
		System.out.println("Para cada execução observar que a ordem é alterada:");
		lista.parallelStream()
			.forEach(System.out::println);
		
		System.out.println("\nOrdenado:");
		lista.parallelStream()
			.forEachOrdered(System.out::println);
		
		
		// Exemplo FINDANY - valor vem da thread que acabar primeiro
		System.out.println("\nFindAny paralelo:");
		lista.parallelStream()
			.findAny()
			.ifPresent(System.out::println);
		
		System.out.println("\nFindAny Não parapelo:");
		lista.stream()
			.findAny()
			.ifPresent(System.out::println);
		
		// exemplo UNORDERED, recomendado p/ casos com skip e limit
		System.out.println("\nUNORDERED:");
		lista.parallelStream()
			.unordered()
			.skip(1)
			.limit(3)
			.forEach(System.out::println);
		
		// Exemplo REDUCE
		// toma cuidado pois ao utilizar paralelo, considerar que precisa
		// ser associativo, do contrário o resultado será incorreto
		// (1 + 2) + (3 + 4) = 10 - ASSOCIATIVA - não importa os parentese, o resultado não muda
		// (1 - 2) - (3 - 4) = 0 ? - não associativo, 
		System.out.println("\nREDUCE paralelo:");
		lista.parallelStream()
			.reduce((n1, n2) -> n1 - n2) // veja que na soma é 28
			.ifPresent(System.out::println);
		
		// TO MAP
		// com o CONCURRENTMAP, as  thread podem executar separadamente mas retornando em
		// um único mapa e dai juntar es resultados
		System.out.println("\nTOMAP:");
		Map<Integer, Boolean> coleta1 = 
			lista.parallelStream()
				.collect(
					Collectors
						.toConcurrentMap(n -> n, n -> n% 2 == 0)
					);
		System.out.println(coleta1);
				
		
		// GROUPING BY
		// similar ao acima, se for executar, cada thread em parapelo faz o trabalho criando MAP
		// no final tudo se junta ae traz o resultado, normalmente desordenado
		// AGORA se utilizar o CONCURRENT, todo executam e atribui e um map, sem cada um criar o seu e ajuntar
		// ganho de performace
		System.out.println("\nMAP e parapelo:");
		Map<Boolean, List<Integer>> coleta2 = 
			lista.parallelStream()
				.collect(
					Collectors
					.groupingByConcurrent(n -> n % 2 == 0)
				);
		System.out.println(coleta2);
		
	}
	
}
