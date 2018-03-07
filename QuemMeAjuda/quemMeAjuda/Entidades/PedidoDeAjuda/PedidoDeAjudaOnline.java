package quemMeAjuda.Entidades.PedidoDeAjuda;

import quemMeAjuda.Entidades.Aluno.*;
public class PedidoDeAjudaOnline implements PedidoDeAjuda{

	private String disciplina, matricula;
	private Aluno tutor;
	private boolean finalizada;
	
	public PedidoDeAjudaOnline(Aluno tutor, String matricula, String disciplina) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.tutor = tutor;
		this.finalizada = false;
	}

	@Override
	public boolean getFinalizacao() {
		return finalizada;
	}
	
	@Override
	public void setFinalizacao(boolean fechouOuNao) {
		this.finalizada = fechouOuNao;
	}
	
	@Override
	public Aluno getTutor() {
		return tutor;
	}

	@Override
	public String getInfoAjuda(String atributo) {
		switch(atributo) {
			case "disciplina":
				return this.disciplina;
			default:
				return null;
		}
	}

	@Override
	public String getMatriculaAluno() {
		return matricula;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + tutor.getMatricula() + ", disciplina - " + disciplina;
	}
}