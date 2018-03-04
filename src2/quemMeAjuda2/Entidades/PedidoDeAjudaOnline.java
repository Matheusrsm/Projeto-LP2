package quemMeAjuda.Entidades;

public class PedidoDeAjudaOnline implements PedidoDeAjuda{

	private String disciplina, matricula;
	private Tutor tutor;
	
	public PedidoDeAjudaOnline(String matricula, String disciplina, Tutor tutor) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.tutor = tutor;
	}
	
	@Override
	public String getDia() {
		return null;
	}

	@Override
	public String getLocal() {
		return null;
	}

	@Override
	public String getDisciplina() {
		return disciplina;
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