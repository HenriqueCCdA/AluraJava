package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {

	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	@BeforeEach
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("João");
		this.jose = new Usuario("Jose");
		this.maria = new Usuario("Maria");
	}

	@Test
	public void deveCalcularAMedia() {
		// parte 1: cenario
		Leilao leilao = new CriadorDeLeilao().para("Playstantion 3 Novo")
				.lance(joao, 300.0)
				.lance(jose, 400.0)
				.lance(maria, 500.0)
				.constroi();

		// parte 2: acao
		leiloeiro.avalia(leilao);

		// parte 3: validacao
		assertEquals(400.0, leiloeiro.getMedia(), 0.00001);

	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// parte 1: cenario
		Leilao leilao = new CriadorDeLeilao().para("Playstantion 3 Novo")
				.lance(joao, 250.0)
				.lance(jose, 300.0)
				.lance(maria, 400.0)
				.constroi();

		// parte 2: acao
		leiloeiro.avalia(leilao);

		// parte 3: validacao
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveEntenderLancesComApenasUmLance() {
		// parte 1: cenario
		Leilao leilao = new CriadorDeLeilao().para("Playstantion 3 Novo").lance(joao, 1000.0).constroi();

		// parte 2: acao
		leiloeiro.avalia(leilao);

		// parte 3: validacao
		double maiorEsperado = 1000.0;
		double menorEsperado = 1000.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveEncontrarOsTresMaioresLance() {
		// parte 1: cenario
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstantion 3 Novo")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(maria, 400.0)
				.constroi();

		// parte 2: acao
		leiloeiro.avalia(leilao);

		// parte 3: validacao

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
	}

	@Test
	public void deveEntenderLeilaoComLancesEmOrdemRandomica() {

		// parte 1: cenario
		Leilao leilao = new CriadorDeLeilao().para("Playstantion 3 Novo")
				.lance(joao, 200.0)
				.lance(maria, 450.0)
				.lance(joao, 120.0)
				.lance(maria, 700.0)
				.lance(joao, 630.0)
				.lance(maria, 230.0)
				.constroi();

		// parte 2: acao
		leiloeiro.avalia(leilao);
		
		// parte 3: validacao
		assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
		try {
			Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();
			leiloeiro.avalia(leilao);
			Assert.fail();
		}
		catch(RuntimeException e) {
			
		}
	}

}
