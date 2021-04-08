package br.com.alura.teste;

import java.util.Iterator;
import java.util.Set;

import br.com.alura.Aluno;
import br.com.alura.Aula;
import br.com.alura.Curso;

public class TestaCursoComAluno {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);

		System.out.println("Todos os alunos matriculados: ");
		System.out.println("Forma atual");
		javaColecoes.getAlunos().forEach(aluno -> System.out.println(aluno));
		
		
		System.out.println("Forma antiga");
		Set<Aluno> alunos = javaColecoes.getAlunos();
		Iterator<Aluno> iterador = alunos.iterator();
		
		while(iterador.hasNext()) {
			Aluno proximo = iterador.next();
			System.out.println(proximo);			
		}
		
		
		System.out.println("O aluno a1, está matriculado ?");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno turini = new Aluno("Rodrigo Turini", 34672);
		
		System.out.println("Testando o equals");
		System.out.println(a1.equals(turini));						
	
		System.out.println("E esse Turini, está matriculado ?");
		System.out.println(javaColecoes.estaMatriculado(turini));
		
		System.out.println("E esse Turini, está matriculado ?");
		System.out.println(a1.hashCode() == turini.hashCode());
	}

}
