package com.java8.Lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CriandoCollections {
	
	public static void main(String[] args) {
		
		List<Integer> lista = new ArrayList<>();
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		lista.forEach(n -> System.out.println(n));
		
		// exemplo REMOVEIF
		lista.removeIf(n -> n % 2 == 0);
		lista.forEach(n -> System.out.println(n));
		
		// exemplo REPLACE ALL
		lista.replaceAll(n -> n * 2);
		lista.forEach(n -> System.out.println(n));
		
		System.out.println("HashMap:");
		
		HashMap<Integer, String> mapa = new HashMap<>();
		mapa.put(0, "Olá");
		mapa.put(1, "como");
		mapa.put(2, "vai");
		mapa.put(3, "você");

		// a = key b = value
		mapa.forEach((a, b) -> System.out.println(a + b));
		mapa.forEach((a, b) -> System.out.print(b + " "));
		
		System.out.println("\n\nCOMPUTE:");
		
		// exemplo COMPUTE
		mapa.compute(0, (a, b) -> b + " opa");
		mapa.forEach((a, b) -> System.out.print(a + b));
		
		System.out.println("\n\nMERGE:");
		
		// exemplo MERGE
		// se der de não achar valor, é substituido
		// pela variável informada
		mapa.merge(3, "?", (a, b) -> a + b );
		mapa.forEach((a, b) -> System.out.println(a + b));
		
		System.out.println("\nREPLACEALL:");
		
		// Exemplo REPLACEALL
		mapa.replaceAll( (a, b) -> b + "*" );
		mapa.forEach((a, b) -> System.out.println(a + b));
		
	}
}
