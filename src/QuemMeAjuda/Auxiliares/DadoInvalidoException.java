package QuemMeAjuda.Auxiliares;

/**
 * Classe responsavel por lancar excecao de dados invalidos.
 * @author Lukas Nascimento
 *
 */

public class DadoInvalidoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Mostra mensagem de excecao de dado inválido
	 * @param msg
	 * 		mensagem a ser exibida
	 */
	public DadoInvalidoException(String msg) {
		super(msg);
	}
}
