package quemMeAjuda.Entidades.PedidoDeAjuda;

import quemMeAjuda.Entidades.Aluno.*;

/**
 * Classe PedidoDeAjudaPresencial (extende PedidoDeAjuda)
 * Um objeto PedidoDeAjudaPresencial é composto por:
 * Matricula do Aluno;
 * Disciplina;
 * Tutor (objeto Aluno);
 * Horario;
 * Dia;
 * Local;
 * 
 * @author Lukas, Wesley, Matheus
 *
 */
public class PedidoDeAjudaPresencial extends PedidoDeAjuda {

	private static final long serialVersionUID = 353215511292577905L;
	private String dia, local, horario;
	
	/**
	 * Constroi um pedido de ajuda a partir do Tutor que deve atender a essa ajuda,
	 * a matricula do aluno que a pediu, a disciplina que o aluno deseja receber ajuda e
	 * o horario, dia e local que o aluno determinou.
	 * @param tutor objeto do Tutor que deve atender a essa ajuda.
	 * @param matricula matricula do aluno que pediu ajuda.
	 * @param disciplina nome da disciplina que o aluno pediu ajuda.
	 * @param horario representacao textual da hora que deseja ser atendido
	 * @param dia dia da semana que o aluno prefere
	 * @param local local que o aluno prefere
	 */
	public PedidoDeAjudaPresencial(Aluno tutor, String matricula, String disciplina, String horario, String dia, String local) {
		super(tutor, matricula, disciplina);
		this.horario = horario;
		this.dia = dia;
		this.local = local;
	}

	@Override
	public String getInfoAjuda(String atributo) {
		switch(atributo) {
		case "horario":
			return horario;
		case "dia":
			return dia;
		case "localInteresse":
			return local;
		case "disciplina":
			return disciplina;
		default:
			return null;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + ", horario - " + horario + ", dia - " + dia + ", local - " + local + ", disciplina - " + disciplina;
	}
}