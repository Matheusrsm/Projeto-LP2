package quemMeAjuda2.Entidades.PedidoDeAjuda;

import quemMeAjuda2.Entidades.Aluno.*;
public class PedidoDeAjudaOnline implements PedidoDeAjuda{

	private String disciplina, matricula;
	private Aluno tutor;
	
	public PedidoDeAjudaOnline(Aluno tutor, String matricula, String disciplina) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.tutor = tutor;;
	}

	@Override
	public Aluno getTutor() {
		return tutor;
	}

	@Override
	public String getInfoAjuda(String atributo) {
		switch(atributo.toLowerCase()) {
			case "disciplina":
				return this.disciplina;
			case "matricula":
				return this.matricula;
			default:
				return null;
		}
	}
}