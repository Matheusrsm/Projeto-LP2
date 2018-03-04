package quemMeAjuda.Entidades;

public class PedidoDeAjudaPresencial implements PedidoDeAjuda{

	private String matricula, disciplina, dia, local, horario;
	private Tutor tutor;
	
	public PedidoDeAjudaPresencial(String matricula, String disciplina, String horario, String dia, String local, Tutor tutor) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.horario = horario;
		this.dia = dia;
		this.local = local;
		this.tutor = tutor;
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
	public Tutor getTutor() {
		return tutor;
	}

	@Override
	public String getMatriculaAluno() {
		return matricula;
	}
	
}