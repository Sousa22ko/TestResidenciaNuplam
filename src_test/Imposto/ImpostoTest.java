package Imposto;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import param.CalculoImpostoRenda;

@RunWith(Parameterized.class)
public class ImpostoTest {

	@Parameter(0)
	public double entrada;

	@Parameter(1)
	public double esperado;

	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 10, 10 }, { 1200, 1200 }, { 1500, 1650 }, { 4000, 4400 },
				{ 5555, 6388.25 }, { 9999, 11498.85 }, { 10001, 12001.2 } });
	}

	@Test
	public void test() {
		assertEquals(esperado, CalculoImpostoRenda.calculaImposto(entrada), 0.1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testError() {
		CalculoImpostoRenda.calculaImposto(-1);
	}
}
