package br.com.alura.teste;

import br.com.alura.Aula;
import br.com.alura.Curso;

public class testaCurso2 {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
				
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 20));
		
		System.out.println(javaColecoes.getAulas());
	}
	
	
}
