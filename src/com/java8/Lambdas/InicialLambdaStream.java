package com.java8.Lambdas;

import java.util.Arrays;
import java.util.List;


public class InicialLambdaStream {
	
	/**
	 * Por que utilizar lambda? não só ajuda a diminuir código mas na utilização
	 * da STREAM implantada no java 8
	 */
	public static void main(String[] args) {

		List<Integer> lista = Arrays.asList(1,2,3,4,5,6);
		
		// método comum para iterar uma lista
		for (Integer integer : lista) {
			System.out.println(integer);
		}
		
		// agora utilizando o STREAM, que possui grande quantidade de métodos
		lista.stream()
			.forEach(e -> System.out.println("utilizando stream:" + e));
		
		// utilziando stream para imprimir número pares
		lista.stream()
			.filter(e -> e % 2 == 0) // pegando número par 
			.forEach(e -> System.out.println("par: " + e));
		
	}

}
