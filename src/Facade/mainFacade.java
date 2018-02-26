package Facade;

import exceptions.DadoInvalidoException;

public class mainFacade {
	private static Facade sis;
	public static void main(String[] args) throws DadoInvalidoException {
		sis = new Facade();
		sis.cadastrarAluno("Matthew Melio", "115260904", 10000, "", "matthew.met@ccc.ufcg.edu.br");
		System.out.println(sis.recuperaAluno("115260904"));
	
	}
}
