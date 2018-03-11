package quemMeAjuda.Entidades.PedidoDeAjuda;

import java.io.Serializable;

import quemMeAjuda.Entidades.Aluno.Aluno;

public abstract class PedidoDeAjuda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8035229549214584828L;
	private String matriculaAluno;
	protected String disciplina;
	private Aluno tutor;
	private boolean finalizada;
	
	public PedidoDeAjuda(Aluno tutor, String matricula, String disciplina) {
		this.tutor = tutor;
		this.matriculaAluno = matricula;
		this.disciplina = disciplina;
		this.finalizada = false;
	}

	public abstract String getInfoAjuda(String atributo);
	
	public Aluno getTutor() {
		return tutor;
	}
	
	public String getMatriculaAluno() {
		return matriculaAluno;
	}
	
	public boolean getFinalizacao() {
		return finalizada;
	}
	
	public void setFinalizacao(boolean fechouOuNao) {
		this.finalizada = fechouOuNao;
	}

	@Override
	public String toString() {
		return "Tutor - " + tutor.getMatricula();
	}
}
