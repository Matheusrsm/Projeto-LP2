package quemMeAjuda.Entidades.PedidoDeAjuda;

import java.io.Serializable;

import quemMeAjuda.Entidades.Aluno.Aluno;

/**
 * Classe abstrata PedidoDeAjuda
 * Um objeto PedidoDeAjuda é composto por:
 * Matricula do Aluno;
 * Disciplina;
 * Tutor (objeto Aluno);
 * Variável booleana que representa se o pedido foi finalizado;
 * 
 * @author Lukas, Wesley, Matheus
 *
 */
public abstract class PedidoDeAjuda implements Serializable {
	
	private static final long serialVersionUID = 8035229549214584828L;
	private String matriculaAluno;
	protected String disciplina;
	private Aluno tutor;
	private boolean finalizado;
	
	public PedidoDeAjuda(Aluno tutor, String matricula, String disciplina) {
		this.tutor = tutor;
		this.matriculaAluno = matricula;
		this.disciplina = disciplina;
		this.finalizado = false;
	}

	public abstract String getInfoAjuda(String atributo);
	
	public Aluno getTutor() {
		return tutor;
	}
	
	public String getMatriculaAluno() {
		return matriculaAluno;
	}
	
	public boolean getFinalizacao() {
		return finalizado;
	}
	
	/**
	 * Define se o objeto PedidoDEAjuda foi, ou não, finalizado
	 * @param fechouOuNao
	 */
	public void setFinalizacao(boolean fechouOuNao) {
		this.finalizado = fechouOuNao;
	}

	@Override
	public String toString() {
		return "Tutor - " + tutor.getMatricula();
	}
}
