package fila;
public class FilaException extends RuntimeException {

	public FilaException(){
		super();
	}

	public FilaException(String mensagem){
		super(mensagem);
	}

	public FilaException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}