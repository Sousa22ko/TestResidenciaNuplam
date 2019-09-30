package fila;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FilaTest {

	private Fila fila;

	@Test
	public void testConst() {
		fila = new Fila();
		assertTrue(fila.getTam() == fila.getCapacidade());
	}

	@Test
	public void testConst2() {
		fila = new Fila(10);
		assertTrue(fila.getTam() == 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConst3() {
		fila = new Fila(-10);
	}

	@Test
	public void testInsereFila() {
		fila = new Fila();
		fila.insereNaFila("1");
		fila.insereNaFila("2");
		fila.insereNaFila("3");
		fila.insereNaFila("4");

		assertTrue(fila.getFim() == 3);
		assertFalse(fila.estaVazia());
		assertFalse(fila.estaCheia());
	}
	
	@Test(expected = FilaCheiaException.class)
	public void testInsereFilaCheia() {
		fila = new Fila();
		fila.insereNaFila("1");
		fila.insereNaFila("2");
		fila.insereNaFila("3");
		fila.insereNaFila("4");
		fila.insereNaFila("5");
		fila.insereNaFila("6");
	}

	@Test
	public void testRemoveFila() {
		fila = new Fila();
		fila.insereNaFila("1");
		fila.insereNaFila("2");
		fila.insereNaFila("3");
		fila.insereNaFila("4");

		fila.removeDaFila();
		assertTrue(fila.getFim() == 2);
	}

	@Test(expected = FilaVaziaException.class)
	public void testRemoveFilaVazia() {
		fila = new Fila();
		fila.insereNaFila("1");

		fila.removeDaFila();
		fila.removeDaFila();
	}

	@Test
	public void testLimparFila() {
		fila = new Fila();
		fila.insereNaFila("1");
		fila.insereNaFila("2");
		fila.insereNaFila("3");
		fila.insereNaFila("4");

		fila.limpaFila();
		assertTrue(fila.getFim() == -1);
	}
	
	@Test
	public void testInsereFinal() {
		fila = new Fila();
		fila.insereNaFila("1");
		fila.insereNaFila("2");
		fila.insereNaFila("3");
		String comparacao = "valor final da lista";
		
		fila.insereNaFila(comparacao);
		
		assertTrue(fila.getObject(3).equals(comparacao));
	}
	
	@Test
	public void testRemoveInicio() {
		fila = new Fila();
		fila.insereNaFila("1");
		String comparacao = "valor final da lista";
		fila.insereNaFila(comparacao);
		fila.insereNaFila("3");
		fila.insereNaFila("4");
		
		fila.removeDaFila();
		
		assertTrue(fila.getObject(0).equals(comparacao));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExcessao() {
		fila = new Fila();
		
		fila.getObject(3).equals("");
	}

}
