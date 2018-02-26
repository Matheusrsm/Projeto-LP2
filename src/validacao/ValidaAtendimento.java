package validacao;

import exceptions.DadoInvalidoException;

public class ValidaAtendimento {
	
	public static void validaHorario(String horario, String dia) throws DadoInvalidoException {
		if (horario.trim().isEmpty())
			throw new DadoInvalidoException("horario nao pode ser vazio ou em branco");
		
		if (dia.trim().isEmpty())
			throw new DadoInvalidoException("dia nao pode ser vazio ou em branco");
	}
	
	

}
