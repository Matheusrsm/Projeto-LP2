package validacao;

import exceptions.DadoInvalidoException;

public class ValidaTutor {
	public static void validaProficiencia(int proficiencia) throws DadoInvalidoException{
		if (proficiencia < 0)
			throw new DadoInvalidoException("Proficiencia invalida");
	}

}
