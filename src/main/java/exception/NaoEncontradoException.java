package exception;

public class NaoEncontradoException extends RuntimeException {
	public NaoEncontradoException() {
	
	}
	
	public NaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
