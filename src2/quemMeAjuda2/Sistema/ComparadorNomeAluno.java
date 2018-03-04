package quemMeAjuda2.Sistema;

import java.util.Comparator;
import quemMeAjuda2.Entidades.Aluno.*;

public class ComparadorNomeAluno implements Comparator<Aluno> {
	
	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getNome().compareTo(a2.getNome());
	}
}
