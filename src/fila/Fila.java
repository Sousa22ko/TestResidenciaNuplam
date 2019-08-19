package fila;

public class Fila implements IFila {

	private static final int capacidade = 5;
	private Object[] Fila; // Array que representa a fila
	private final int tam; // capacidade total da fila
	private int fim = -1; // final da fila

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public int getTam() {
		return tam;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public Fila() {
		this(capacidade);
	}

	public Fila(int cap) throws FilaException {
		if (cap > 0)
			tam = cap;
		else
			throw new FilaException();
		Fila = new Object[tam];
	}

	public int tamanho() {
		return fim;
	}

	public boolean estaVazia() {
		return (fim == -1) ? true : false;
	}

	public boolean estaCheia() {
		return (fim == tam) ? true : false;
	}

	public void insereNaFila(Object obj) throws FilaCheiaException {
		if(fim + 1 >= tam)
			throw new FilaCheiaException();
		
		fim++;
		Fila[fim] = obj;
	}

	public Object removeDaFila() throws FilaVaziaException {
		if(fim == -1)
			throw new FilaVaziaException();
		
		Object item = Fila[0];
		for (int k = 1; k < fim; k++)
			Fila[k - 1] = Fila[k];
		
		fim --;
		return item;
	}

	@SuppressWarnings("unused")
	public void limpaFila() {
		for (Object aux : Fila) {
			aux = null;
		}
		fim = -1;
	}
}
