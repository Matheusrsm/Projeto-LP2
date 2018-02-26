package validacao;

import exceptions.DadoInvalidoException;

public class ValidaAluno {
		
	public static void validaNome(String nome) throws DadoInvalidoException {
		if (nome == null || nome.trim().isEmpty())
			throw new DadoInvalidoException("Nome do aluno nao pode ser vazio ou nulo");
		}
	
	public static void validaEmail(String email) throws DadoInvalidoException {
		int a = 0;
		boolean erro = true;
		
		for (int i = 0; i < email.length(); i++)
			if (email.charAt(i) == '@')
				a = i;
		for (int i = 0; i < a; i++ )
			if (email.charAt(i) != ' ')
				erro = false;
		for (int i = email.length() -1; i > a; i-- )
			if (email.charAt(i) != ' ')
				erro = false;
		if (erro)
			throw new DadoInvalidoException("Email invalido");
	}
}