package quemMeAjuda.Excecoes;

/**
 * Classe de Exceção de DadoNulo
 * @author lukasnascimento
 *
 */
public class DadoNuloException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Mostra a mensagem de exceção de dado nulo
	 * @param msg
	 * 		mensagem a ser exibida
	 */
	public DadoNuloException(String msg) {
		super(msg);
	}

}
