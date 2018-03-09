package quemMeAjuda.Comparadores;

import java.io.Serializable;
import java.util.Comparator;

import quemMeAjuda.Entidades.Aluno.Aluno;

public class ComparadorMatricula implements Comparator<Aluno>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7897599526975120398L;

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getMatricula().compareTo(a2.getMatricula());
	}

}
