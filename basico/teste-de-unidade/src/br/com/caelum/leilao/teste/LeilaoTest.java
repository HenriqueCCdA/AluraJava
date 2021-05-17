package br.com.caelum.leilao.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		
	}
	
	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Macbook Pro 15");
				
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000.0));
		leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000.0));
		

		assertEquals(2, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.00001);
		
	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
			
		Usuario usuario = new Usuario("Steve Jobs");
		
		leilao.propoe(new Lance(usuario, 2000.0));
		leilao.propoe(new Lance(usuario, 3000.0));
		

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);

	}
	
	@Test
	public void naoDeveAceitarMaisDeCincoLancesDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
			
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");
		
		leilao.propoe(new Lance(steveJobs, 2000.0));
		leilao.propoe(new Lance(billGates, 3000.0));

		leilao.propoe(new Lance(steveJobs, 4000.0));
		leilao.propoe(new Lance(billGates, 5000.0));
		
		leilao.propoe(new Lance(steveJobs, 6000.0));
		leilao.propoe(new Lance(billGates, 7000.0));
		
		leilao.propoe(new Lance(steveJobs, 8000.0));
		leilao.propoe(new Lance(billGates, 9000.0));
		
		leilao.propoe(new Lance(steveJobs,10000.0));
		leilao.propoe(new Lance(billGates,11000.0));
		
		//deve ser ignorado
		
		leilao.propoe(new Lance(steveJobs,12000.0));
		
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(11000.0, leilao.getLances().get(9).getValor(), 0.00001);


	}
	
}
