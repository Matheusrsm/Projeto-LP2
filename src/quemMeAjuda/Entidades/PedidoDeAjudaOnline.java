package quemMeAjuda.Entidades;

public class PedidoDeAjudaOnline implements PedidoDeAjuda{

	private String disciplina;
	private Tutor tutor;
	
	public PedidoDeAjudaOnline(String disciplina, Tutor tutor) {
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
}