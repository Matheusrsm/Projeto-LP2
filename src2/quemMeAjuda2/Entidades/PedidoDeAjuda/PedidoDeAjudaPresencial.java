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
	public Aluno getTutor() {
		return tutor;
	}

	public void setTutor(Aluno tutor) {
		this.tutor = tutor;
	}

	@Override
	public String getInfoAjuda(String atributo) {
		switch(atributo.toLowerCase()) {
		case "horario":
			return this.horario;
		case "dia":
			return this.dia;
		case "localInteresse":
			return this.local;
		case "disciplina":
			return this.disciplina;
		case "matricula":
			return this.matricula;
		default:
			return null;
	}
	}
	
}