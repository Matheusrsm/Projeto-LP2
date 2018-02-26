package QuemMeAjuda;

import exceptions.DadoInvalidoException;

public class mainSistema {
	private static Sistema sis;
	/**
	 * Linhas de Código para Teste de Saída.
	 * @param args
	 * @throws DadoInvalidoException 
	 */
	public static void main(String[] args) throws DadoInvalidoException {
		sis = new Sistema();
		sis.cadastrarAluno("Matthew Melio", "115260904", 10000, "", "matthew.met@ccc.ufcg.edu.br");
		System.out.println(sis.recuperaAluno("115260904"));
	
	}
}

//115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br
//115260904 - Matthew Mello - 10000 - matthew.met@ccc.ufcg.edu.br
