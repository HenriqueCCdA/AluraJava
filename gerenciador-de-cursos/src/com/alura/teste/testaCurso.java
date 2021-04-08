package br.com.alura.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.Aula;
import br.com.alura.Curso;

public class testaCurso {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
				
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
		
		List<Aula> aulasImataveis = javaColecoes.getAulas();
		
		System.out.println(aulasImataveis);
		
		List<Aula> aulas = new ArrayList<>(aulasImataveis);
		
		Collections.sort(aulas);
		
		System.out.println(aulas);
		
		System.out.println(javaColecoes.getTempoTotal());
		
		System.out.println(javaColecoes);
		
	}
	
	
}
