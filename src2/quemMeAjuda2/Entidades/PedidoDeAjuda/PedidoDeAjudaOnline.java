package quemMeAjuda2.Entidades.PedidoDeAjuda;

public class PedidoDeAjudaOnline implements PedidoDeAjuda{

	private String disciplina, matricula;
	
	public PedidoDeAjudaOnline(String matricula, String disciplina) {
		this.matricula = matricula;
		this.disciplina = disciplina;
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
	public String getMatriculaAluno() {
		return matricula;
	}
}