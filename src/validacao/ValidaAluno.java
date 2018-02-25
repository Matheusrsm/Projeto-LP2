package validacao;

import exceptions.DadoInvalidoException;

public class ValidaAluno {
		
	public static void testNome(String nome) throws DadoInvalidoException {
		if (nome == null || nome.trim().isEmpty())
			throw new DadoInvalidoException("Nome do aluno nao pode ser vazio ou nulo");
		}
	
}
