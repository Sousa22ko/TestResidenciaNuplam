package Imposto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import param.CalculoImpostoRenda;

public class ImpostoEquivalenciaTest {

	// classe de equivalencia ao intervalo 0~1200 (0% de imposto)
	@Test
	public void testClasse1() {
		assertEquals(10, CalculoImpostoRenda.calculaImposto(10), 0.1);
		assertEquals(1200, CalculoImpostoRenda.calculaImposto(1200), 0.1);
	}

	// classe de equivalencia ao intervalo 1201~5000 (10% de imposto)
	@Test
	public void testClasse2() {
		assertEquals(1320.11, CalculoImpostoRenda.calculaImposto(1200.1), 0.1);
		assertEquals(1321.1, CalculoImpostoRenda.calculaImposto(1201), 0.1);
		assertEquals(1650, CalculoImpostoRenda.calculaImposto(1500), 0.1);
		assertEquals(4160.2, CalculoImpostoRenda.calculaImposto(3782), 0.1);
		assertEquals(4400, CalculoImpostoRenda.calculaImposto(4000), 0.1);
		assertEquals(5500, CalculoImpostoRenda.calculaImposto(5000), 0.1);
	}

	// classe de equivalencia ao intervalo 5001~10000 (15% de imposto)
	@Test
	public void testClasse3() {
		assertEquals(5750.12, CalculoImpostoRenda.calculaImposto(5000.1), 0.1);
		assertEquals(5751.15, CalculoImpostoRenda.calculaImposto(5001), 0.1);
		assertEquals(6388.25, CalculoImpostoRenda.calculaImposto(5555), 0.1);
		assertEquals(11498.85, CalculoImpostoRenda.calculaImposto(9999), 0.1);
		assertEquals(11500, CalculoImpostoRenda.calculaImposto(10000), 0.1);
	}

	// classe de equivalencia ao intervalo 10000+ (20% de imposto)
	@Test
	public void testClasse4() {
		assertEquals(12000.2, CalculoImpostoRenda.calculaImposto(10000.1), 0.1);
		assertEquals(12001.2, CalculoImpostoRenda.calculaImposto(10001), 0.1);
		assertEquals(24000, CalculoImpostoRenda.calculaImposto(20000), 0.1);
		assertEquals(1200000, CalculoImpostoRenda.calculaImposto(1000000), 0.1);
	}

	// Classe de equivalencia inválida
	@Test(expected = IllegalArgumentException.class)
	public void testError() {
		CalculoImpostoRenda.calculaImposto(-1);
	}

	// Classe de equivalencia inválida
	@Test(expected = IllegalArgumentException.class)
	public void testError0() {
		CalculoImpostoRenda.calculaImposto(0);
	}
}
