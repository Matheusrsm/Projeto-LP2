package Comparadores;

import java.io.Serializable;
import java.util.Comparator;

import quemMeAjuda.Entidades.Aluno.Aluno;

public class ComparadorEmail implements Comparator<Aluno>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4136534107185507486L;

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getEmail().compareTo(a2.getEmail());
	}

}
