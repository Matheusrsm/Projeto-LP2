package quemMeAjuda.Entidades.PedidoDeAjuda;

import quemMeAjuda.Entidades.Aluno.Aluno;

public interface PedidoDeAjuda {

	String getInfoAjuda(String atributo);
	Aluno getTutor();
	String getMatriculaAluno();
	boolean getFinalizacao();
	void setFinalizacao(boolean fechouOuNao);
}
