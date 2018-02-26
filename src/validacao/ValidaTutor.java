package validacao;

import exceptions.DadoInvalidoException;

public class ValidaTutor {
	
	public static void validaProficiencia(int proficiencia) throws DadoInvalidoException{
		if (proficiencia < 0)
			throw new DadoInvalidoException("Proficiencia invalida");
	}
	
	public static void validaEmail(String email) throws DadoInvalidoException {
		if (email.trim().isEmpty())
			throw new DadoInvalidoException("email nao pode ser vazio ou em branco");
	}

}
