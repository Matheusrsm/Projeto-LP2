package quemMeAjuda.Entidades.PedidoDeAjuda;

import quemMeAjuda.Entidades.Aluno.*;
public class PedidoDeAjudaPresencial implements PedidoDeAjuda{

	private String matricula, disciplina, dia, local, horario;
	private Aluno tutor;
	private boolean finalizada;
	
	public PedidoDeAjudaPresencial(Aluno tutor, String matricula, String disciplina, String horario, String dia, String local) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.horario = horario;
		this.dia = dia;
		this.local = local;
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
		case "horario":
			return this.horario;
		case "dia":
			return this.dia;
		case "localInteresse":
			return this.local;
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
		return "Tutor - " + tutor.getMatricula() + ", horario - " + horario + ", dia - " + dia + ", local - " + local + ", disciplina - " + disciplina;
	}
}