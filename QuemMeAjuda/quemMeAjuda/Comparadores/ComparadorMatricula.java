package quemMeAjuda.Comparadores;

import java.util.Comparator;

import quemMeAjuda.Entidades.Aluno.Aluno;

public class ComparadorMatricula implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getMatricula().compareTo(a2.getMatricula());
	}
}