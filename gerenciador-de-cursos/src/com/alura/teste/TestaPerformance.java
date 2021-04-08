package br.com.alura.teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {
		Collection<Integer> numeros = new ArrayList<Integer>();

		long inicio = System.currentTimeMillis();

		for (int i = 1; i <= 100000; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}

		long fim = System.currentTimeMillis();

		long tempoDeExecucao = fim - inicio;

		System.out.println("List");
		System.out.println("Tempo gasto: " + tempoDeExecucao/1000.0 + " s");
		
		numeros = new HashSet<Integer>();

		inicio = System.currentTimeMillis();

		for (int i = 1; i <= 100000; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}

		fim = System.currentTimeMillis();

		tempoDeExecucao = fim - inicio;
		
		System.out.println("Set");
		System.out.println("Tempo gasto: " + tempoDeExecucao/1000.0 + " s");		
		

	}

}
