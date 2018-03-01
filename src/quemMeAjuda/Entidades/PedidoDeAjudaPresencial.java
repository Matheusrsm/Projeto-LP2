package quemMeAjuda.Entidades;

public class PedidoDeAjudaPresencial implements PedidoDeAjuda{

	private String disciplina, dia, local, horario;
	
	public PedidoDeAjudaPresencial(String disciplina, String horario, String dia, String local) {
		this.disciplina = disciplina;
		this.horario = horario;
		this.dia = dia;
		this.local = local;
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
}