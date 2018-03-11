package quemMeAjuda.Comparadores;

import java.util.Comparator;

import quemMeAjuda.Entidades.Aluno.Aluno;

/**
 * Classe que implementa a interface Comparator.
 * Compara através das Matriculas dos Alunos a serem comparados.
 * 
 * @author Matheus Silva, Wesley Monte
 *
 */
public class ComparadorMatricula implements Comparator<Aluno> {

	/**
	 * Compara dois Alunos através da Matricula (String).
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getMatricula().compareTo(a2.getMatricula());
	}
}