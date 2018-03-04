package quemMeAjuda2.Entidades.PedidoDeAjuda;

import quemMeAjuda2.Entidades.Aluno.*;
public class PedidoDeAjudaPresencial implements PedidoDeAjuda{

	private String matricula, disciplina, dia, local, horario;
	private Aluno tutor;
	
	public PedidoDeAjudaPresencial(String matricula, String disciplina, String horario, String dia, String local) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.horario = horario;
		this.dia = dia;
		this.local = local;
		setTutor(null);
	}
	
	@Override
	public String getDia() {
		return dia;
	}

	@Override
	public String getLocal() {
		return local;
	}

	@Override
	public String getDisciplina() {
		return disciplina;
	}

	public String getHorario() {
		return horario;
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