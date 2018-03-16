package quemMeAjuda.Entidades.Aluno;

import java.io.Serializable;

/**
 *
 * Classe Disciplina.
 * Um objeto Disciplina compõe a classe Tutoria, onde um Aluno é tutor de tal(is) disciplina(s)
 * Uma Disciplina tem:
 * Nome
 * Proficiencia (do tutor na disciplina)
 *
 * @author Lukas, Matheus, Wesley
 *
 */
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 4667862378435164134L;
	private String nome;
	private double proficiencia;
	
	public Disciplina(String nome, double proficiencia) {
		this.nome = nome;
		this.proficiencia = proficiencia;
	}

	public String getNome() {
		return nome;
	}

	public double getProficiencia() {
		return proficiencia;
	}
	
}
