package quemMeAjuda.Entidades;

public class PedidoDeAjudaOnline implements PedidoDeAjuda{

	private String disciplina;
	
	public PedidoDeAjudaOnline(String disciplina) {
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
}