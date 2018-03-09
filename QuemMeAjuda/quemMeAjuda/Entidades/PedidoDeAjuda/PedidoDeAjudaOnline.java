package quemMeAjuda.Entidades.PedidoDeAjuda;

import quemMeAjuda.Entidades.Aluno.*;

public class PedidoDeAjudaOnline extends PedidoDeAjuda {

	public PedidoDeAjudaOnline(Aluno tutor, String matricula, String disciplina) {
		super(tutor, matricula, disciplina);
	}

	@Override
	public String getInfoAjuda(String atributo) {
		if(atributo.equals("disciplina"))
			return getDisciplina();
		return null;
	}

	@Override
	public String toString() {
		return super.toString() + ", disciplina - " + getDisciplina();
	}
}