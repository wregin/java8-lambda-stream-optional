package com.java8.Stream;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsCollect {
	public static void main(String[] args) {
		
		List<Integer> lista = Arrays.asList(1,2,3,4,5,6);
		
		//       fornecedor - acumulação - combinação
		//.collect(supplier, accumulator, combiner)
		
		// exemplo de coletor
		List<Integer> collect = lista.stream()
			.collect(
				() -> new ArrayList<>(), 
				(l, e) -> l.add(e), 
				(l1, l2) -> l1.addAll(l2)
			);
		
		System.out.println(lista);
		System.out.println(collect);
		
		// to list
		List<Integer> collect2 = lista.stream()
			.filter((n) -> n % 2 == 0 )
			.collect(Collectors.toList());
		System.out.println("List: " + collect2);
		
		// to deque
		Deque<Integer> collect3 = lista.stream()
			.filter((n) -> n % 2 == 0 )
			.collect(Collectors.toCollection(
					() -> new ArrayDeque<Integer>()
			));
		System.out.println("Deque: " + collect3);
		
		
		// joining
		String join = lista.stream()
			.map(n -> n.toString()) // transformando em string
			.collect(Collectors.joining("f"));
		System.out.println("Join: " + join);
		
		// averaging - média
		Double media = lista.stream()
			.collect(Collectors.averagingInt(n -> n.intValue()));
		System.out.println("média: " + media);
		
		// summing - somando
		Integer soma = lista.stream()
			.collect(Collectors.summingInt(n -> n.intValue()));
		System.out.println("soma: " + soma);
		
		// sumarizando
		IntSummaryStatistics stats = lista.stream()
			.collect(Collectors.summarizingInt(n -> n.intValue()));
		System.out.println("** IntSummaryStatistics **");
		System.out.println("stats média: " + stats.getAverage());
		System.out.println("stats contador: " + stats.getCount());
		System.out.println("stats max: " + stats.getMax());
		System.out.println("stats min: " + stats.getMin());
		System.out.println("stats soma: " + stats.getSum());
		
		// counting
		Long count = lista.stream()
			.filter((n) -> n % 2 == 0)
			.collect(Collectors.counting());
		System.out.println("cont par: " + count);
		
		// max/min
		lista.stream()
			.filter((n) -> n % 2 == 0)
					      // ou minBy
			.collect(Collectors.maxBy(Comparator.naturalOrder()))
			.ifPresent(System.out::println);
		
		// grouping by
		Map<Integer, List<Integer>> groupingBy =  lista.stream()
			.collect(Collectors.groupingBy((n) -> n % 3));
		System.out.println("groupingBy: " + groupingBy);
		
		// partitioning by
		Map<Boolean, List<Integer>> partitioning =  lista.stream()
			.collect(Collectors.partitioningBy((n) -> n % 3 == 0));
		System.out.println("partitioning: " + partitioning);
		
		// toMap
		Map<Integer, Integer> toMap =  lista.stream()
			.collect(Collectors.toMap(n -> n, n -> n * 2));
		System.out.println("toMap: " + toMap);
		
		// toMap
		Map<Integer, Double> toMap2 =  lista.stream()
			.collect(Collectors.toMap(
				n -> n, 
				n -> Math.pow(n.doubleValue(), 
				5))); 
		System.out.println("toMap2: " + toMap2);
		
	}
}
