package br.com.alura.teste;

import java.util.HashSet;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {
		Set<String> alunos = new HashSet();
		
		alunos.add("Rodrigo Turini");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Segio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");
		alunos.add("Alberto Souza");
		
		System.out.println(alunos.size());
		
		for (String string : alunos) {
			System.out.println(string);
		}
		
		alunos.forEach(aluno -> System.out.println(aluno));
	}
	
}
