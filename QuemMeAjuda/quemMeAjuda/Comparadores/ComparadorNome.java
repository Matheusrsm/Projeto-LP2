package quemMeAjuda.Comparadores;

import java.io.Serializable;
import java.util.Comparator;

import quemMeAjuda.Entidades.Aluno.*;

public class ComparadorNome implements Comparator<Aluno>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3474819607697337285L;

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getNome().compareTo(a2.getNome());
	}
}
