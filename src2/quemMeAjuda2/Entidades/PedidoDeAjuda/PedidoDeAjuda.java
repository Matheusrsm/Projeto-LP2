package quemMeAjuda2.Entidades.PedidoDeAjuda;

import quemMeAjuda2.Entidades.Aluno.Aluno;

public interface PedidoDeAjuda {

	public String getDia();
	public String getLocal();
	public String getDisciplina();
	public String getMatriculaAluno();
	public Aluno getTutor();
}
