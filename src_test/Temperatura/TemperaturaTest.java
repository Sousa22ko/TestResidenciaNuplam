package Temperatura;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import param.temperature.Celsius;
import param.temperature.ConversorTemperatura;
import param.temperature.Fahrenheit;
import param.temperature.TempException;
import param.temperature.Temperatura;

@RunWith(Parameterized.class)
public class TemperaturaTest {

	@Parameter(0)
	public Temperatura entrada;
	@Parameter(1)
	public Temperatura esperado;

	@Parameters
	public static Iterable<Temperatura[]> data() {
		Temperatura[][] t = new Temperatura[][] { 
			{ new Celsius(10), new Fahrenheit(50) }, 
			{ new Celsius(-10), new Fahrenheit(14) }, 
			{ new Celsius(-272.99), new Fahrenheit(-459.382) },
			{ new Celsius(32428.5), new Fahrenheit(58403.3) }, 
			{ new Fahrenheit(0), new Celsius(-17.7778) }, 
			{ new Fahrenheit(256), new Celsius(124.444) }, 
			{ new Fahrenheit(-400.001), new Celsius(-240.0005556) }
		};
		return Arrays.asList(t);
	}

	@Test
	public void test() throws TempException {
		assertEquals(esperado.getValue(), ConversorTemperatura.converte(entrada).getValue(), 0.1);
	}
}
