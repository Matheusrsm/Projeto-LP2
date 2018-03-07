package quemMeAjuda2.Entidades.PedidoDeAjuda;

import quemMeAjuda2.Entidades.Aluno.*;
public class PedidoDeAjudaOnline implements PedidoDeAjuda{

	private String disciplina, matricula;
	private Aluno tutor;
	
	public PedidoDeAjudaOnline(Aluno tutor, String matricula, String disciplina) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.tutor = tutor;
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