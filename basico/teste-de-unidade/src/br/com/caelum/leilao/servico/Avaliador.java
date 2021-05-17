package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double media = 0;
	private List<Lance> maiores;

	public void avalia(Leilao leilao) {

		
		if(leilao.getLances().size() == 0) {
			throw new RuntimeException("Não é possivel avaliar um leilão sem lances!");
			
		}
		
		double total = 0;
		for (Lance lance : leilao.getLances()) {
			double valor = lance.getValor();
			if (valor > maiorDeTodos)
				maiorDeTodos = valor;
			if (valor < menorDeTodos)
				menorDeTodos = valor;
			total += valor;
		}

		if (total != 0) {
			media = total / leilao.getLances().size();
		}

		maiores = new ArrayList<Lance>(leilao.getLances());

//      maiores.sort((s1, s2) -> Double.compare(s1.getValor(), s2.getValor()));	
  		

        maiores.sort(new Comparator<Lance>() {
  		public int compare(Lance o1, Lance o2) {
  				if (o1.getValor() < o2.getValor())
  					return 1;
  				if (o1.getValor() > o2.getValor())
  					return -1;
  				return 0;
  			}
  		});       
		
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());		

	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}

	public double getMedia() {
		return media;
	}
	
	public List<Lance> getTresMaiores() {
		return maiores;
	}
}
