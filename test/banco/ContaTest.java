package banco;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	
	private Conta origem;
	
	@Before
	public void setUp() {
		origem = new Conta("Conta teste", 0);
	}

	@Test
	public void testDebitarSucesso() throws OperacaoIlegalException {
		Conta c = new Conta("123", 20);
		c.debitar(10);
		assertEquals(10, c.getSaldo(), 0.0);
	}

	@Test(expected = OperacaoIlegalException.class)
	public void testTransferir() throws OperacaoIlegalException {
		
		Conta destino = new Conta("Conta teste destino", 0);
		
		double valor = 100.0;
		double transferencia = 110.0;
		
		origem.creditar(valor);
		
		origem.transferir(destino, transferencia);
	}
	
	@Test(expected = OperacaoIlegalException.class)
	public void testTransferir2() throws OperacaoIlegalException {
		
		Conta destino = new Conta("Conta teste destino", 0);
		
		double valor = 100.0;
		double transferencia = -110.0;
		
		origem.creditar(valor);
		
		origem.transferir(destino, transferencia);
	}
	
	@Test
	public void testTransferir3() throws OperacaoIlegalException {
		
		Conta destino = new Conta("Conta teste destino", 0);
		
		double valor = 100.0;
		double transferencia = 90.0;
		
		origem.creditar(valor);
		
		origem.transferir(destino, transferencia);
		assertTrue(origem.getSaldo() == (valor - transferencia));
		assertTrue(destino.getSaldo() == transferencia);
	}
}
