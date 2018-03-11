package quemMeAjuda.Comparadores;

import java.util.Comparator;

import quemMeAjuda.Entidades.Aluno.*;

public class ComparadorNome implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getNome().compareTo(a2.getNome());
	}
}