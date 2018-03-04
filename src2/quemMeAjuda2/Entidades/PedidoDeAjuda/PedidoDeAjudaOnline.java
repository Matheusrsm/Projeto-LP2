package quemMeAjuda2.Entidades.PedidoDeAjuda;

import quemMeAjuda2.Entidades.Aluno.*;
public abstract class PedidoDeAjudaOnline implements PedidoDeAjuda{

	private String disciplina, matricula;
	private Aluno tutor;
	
	public PedidoDeAjudaOnline(String matricula, String disciplina) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		setTutor(null);
	}


	@Override
	public String getDisciplina() {
		return disciplina;
	}

	@Override
	public String getMatriculaAluno() {
		return matricula;
	}

	@Override
	public Aluno getTutor() {
		return tutor;
	}


	public void setTutor(Aluno tutor) {
		this.tutor = tutor;
	}
}