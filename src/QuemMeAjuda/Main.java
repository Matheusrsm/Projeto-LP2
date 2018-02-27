package QuemMeAjuda;

import QuemMeAjuda.Auxiliares.DadoInvalidoException;

public class Main {

	public static void main(String[] args) throws DadoInvalidoException {
		QuemMeAjuda qma = new QuemMeAjuda();
		qma.cadastrarAluno("Matthew Melio", "115260904", 10000, " ", "matthew.met@ccc.ufcg.edu.br");
	}
}
