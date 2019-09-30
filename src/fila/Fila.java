package fila;

public class Fila implements IFila {

	private static final int capacidade = 5;
	private Object[] fila; // Array que representa a fila
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

	public Fila(int cap) throws IllegalArgumentException {
		if (cap > 0)
			tam = cap;
		else
			throw new IllegalArgumentException();
		fila = new Object[tam];
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
	
	public Object getObject(int i) throws IllegalArgumentException{
		if(i < 0 || i > fim)
			throw new IllegalArgumentException();
		return this.fila[i];
	}

	public void insereNaFila(Object obj) throws FilaCheiaException {
		if(fim + 1 >= tam)
			throw new FilaCheiaException();
		
		fim++;
		fila[fim] = obj;
	}

	public Object removeDaFila() throws FilaVaziaException {
		if(fim == -1)
			throw new FilaVaziaException();
		
		Object item = fila[0];
		for (int k = 1; k < fim; k++)
			fila[k - 1] = fila[k];
		
		fim --;
		return item;
	}

	@SuppressWarnings("unused")
	public void limpaFila() {
		for (Object aux : fila) {
			aux = null;
		}
		fim = -1;
	}
}
