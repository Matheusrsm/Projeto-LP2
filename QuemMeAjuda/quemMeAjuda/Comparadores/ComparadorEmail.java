package quemMeAjuda.Comparadores;

import java.util.Comparator;

import quemMeAjuda.Entidades.Aluno.Aluno;

/**
 * Classe que implementa a interface Comparator.
 * Compara através dos Emails dos Alunos a serem comparados.
 * 
 * @author Matheus Silva, Wesley Monte
 *
 */
public class ComparadorEmail implements Comparator<Aluno> {

	/**
	 * Compara dois Alunos através do Email (String).
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getEmail().compareTo(a2.getEmail());
	}
}