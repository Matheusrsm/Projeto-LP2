package exceptions;

/**
 * Classe responsavel por lancar excessao de dados invalidos.
 * @author Lukas Nascimento
 *
 */

public class DadoInvalidoException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Mostra mensagem de excessao de dado inválido
	 * @param message
	 */
	public DadoInvalidoException(String message) {
		super(message);
	}
	
	
	
	
}
