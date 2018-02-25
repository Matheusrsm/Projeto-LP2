package exceptions;

/**
 * Classe responsavel por lancar excessao de dados invalidos.
 * @author Lukas Nascimento
 *
 */
public class DadoInvalidoException extends Exception{
	
	/**
	 * Mostra mensagem de excessao de dado inválido
	 * @param message
	 */
	public DadoInvalidoException(String message) {
		super(message);
	}
	
	
	
	
}
