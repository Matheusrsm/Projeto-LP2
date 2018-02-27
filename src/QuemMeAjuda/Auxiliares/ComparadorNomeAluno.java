package QuemMeAjuda.Auxiliares;

import java.util.Comparator;
import QuemMeAjuda.Entidades.Aluno;

public class ComparadorNomeAluno implements Comparator<Aluno> {
	
	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getNome().compareTo(a2.getNome());
	}
}
