package com.java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class StreamsReduce {
	
	public static void main(String[] args) {
		
		// exemplo do REDUCE com soma
		List<Integer> lista = Arrays.asList(1, 2, 3, 4);
		
		Optional<Integer> reduce = lista.stream()
			.reduce((n1, n2) -> n1 + n2);
			
		System.out.println(reduce.get());
		
		// exemplo do REDUCE com multiplicação			
		Optional<Integer> reduceMulti = lista.stream()
			.reduce((n1, n2) -> n1 * n2);
			
		System.out.println(reduceMulti.get());
		
		// exemplo do REDUCE com string concatenando
		// a ideia é transformar numa coisa só, um elemento
		String s = "utilizando reduce e vamos agora testar";
		String[] split = s.split(" ");
		List<String> listaString = Arrays.asList(split);
		
		Optional<String> reduceConcat = listaString.stream()
			.reduce((s1, s2) -> s1.concat(s2));
			
		System.out.println(reduceConcat.get());
		
		// exemplo do REDUCE com subtração - MUITO CUIDADO COM O PARALELL, 
		// precisa ser associativo para garantir o resultado
		Optional<Integer> reduceSubtracao = lista.stream()
			//.parallel()
			.reduce((n1, n2) -> n1 - n2);
			
		System.out.println(reduceSubtracao.get());		
	
	
		// testando outra "versão" do reduce com valor de identidade
		// Para que? para retornar um valor de identidade, tanto para operação
		// quanto para o caso de não ter nada, retornar o valor de identidade
		
		// soma
		Integer somar = lista.stream()
			.reduce(0,(n1, n2) -> n1 + n2);
		
		System.out.println("somar: " + somar);
		
		// multiplicação
		Integer multi = lista.stream()
			.reduce(1,(n1, n2) -> n1 * n2);
		
		System.out.println("multi: " + multi);
		
		// string 
		String concat = listaString.stream()
			.reduce("", (s1, s2) -> s1.concat(s2));
			
		System.out.println("concat: " + concat);
	
		// Stream double, no caso é utilizado o positive_infinity
		// para o casos onde o valor de identidade não é bem o pesoerado
		Double menorValor = DoubleStream.of(1.5, 2.5, 4.3)
			.reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2) );
		System.out.println("double: " + menorValor);
		
		
	}
	
}
