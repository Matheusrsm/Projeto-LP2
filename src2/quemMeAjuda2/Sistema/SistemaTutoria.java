package quemMeAjuda2.Sistema;

import java.util.Map;

import quemMeAjuda2.Entidades.Aluno.*;
import quemMeAjuda2.Entidades.PedidoDeAjuda.*;
import quemMeAjuda2.validacoes.Validacoes;

/**
 * Classe SistemaTutoria. A classe SistemaTutoria implementa os métodos da interface Sistema
 * em vista de divisão de código e trabalho das classes
 * 
 * @author Lukas Nascimento, Matheus Silva, Wesley Monte
 *
 */
public class SistemaTutoria {
	private Map<String, Aluno> mapaAlunos;
	private Map<Integer, PedidoDeAjuda> pedidos;
	private Validacoes validacoes = new Validacoes();
	
	public SistemaTutoria(Map<String, Aluno> alunos) {
		this.mapaAlunos = alunos;
	}

	/**
	 * Cria um novo objeto PedidoDeAjudaPresencial e implementa qual tutor está sendo associado ao pedido.
	 * O novo objeto é adicionado à lista de pedidos de ajuda do sistema.
	 * @param matrAluno String
	 *		matricula do tutor a ajudar
	 * @param disciplina String
	 * 		disciplina que o aluno deseja ajuda
	 * @param horario String
	 * 		horario que o aluno contratante quer a ajuda
	 * @param dia String static
	 * 		dia que o aluno contratante quer a ajuda
	 * @param localInteresse
	 * 		local que o aluno contratante quer a ajuda
	 * @return
	 * @throws Exception 
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) throws Exception {
		String erroPedirAjudaPresencial = "Erro no pedido de ajuda presencial: ";
		validacoes.matriculaVazia(matrAluno, erroPedirAjudaPresencial);
		validacoes.disciplinaVazia(disciplina, erroPedirAjudaPresencial);
		validacoes.horarioVazio(horario, erroPedirAjudaPresencial);
		validacoes.diaVazio(dia, erroPedirAjudaPresencial);
		validacoes.localVazio(localInteresse, erroPedirAjudaPresencial);
		pedidos.put(pedidos.size(), new PedidoDeAjudaPresencial(tutorAdequado(disciplina, horario, dia, localInteresse), matrAluno, disciplina, horario, dia, localInteresse));
		return pedidos.size() - 1;
		
	}
	
	/**
	 * Verifica qual o Tutor adequado para um pedido de ajuda presencial de acordo com as especifícações de disciplina, horario, dia e local de interesse.
	 * Primeiro é verificado se o Aluno é um Tutor.
	 * Segundo se ele dá tutoria da disciplina desejada.
	 * E em seguida se ele atende no horario, no dia e no local de desejados.
	 * E por fim é escolhido aquele que possui maior proficiencia na disciplina
	 * @param disciplina
	 * 				Disciplina que o Aluno precisa de ajuda
	 * @param horario
	 * 				Horario de interesse do Aluno
	 * @param dia
	 * 				Dia de interesse do Aluno
	 * @param localInteresse
	 * 				Local de interesse do Aluno
	 * @return Matricula do Tutor, uma String.
	 */
	private Aluno tutorAdequado(String disciplina, String horario, String dia, String localInteresse) {
		Aluno tutor = new Aluno(0, "", "", 0, "", "");
		for(Aluno a : mapaAlunos.values()) {
			if(a.isTutor() && a.getTutoria().temDisciplina(disciplina) && verificaHorario(a, horario, dia) && a.getLocais().contains(localInteresse)) {
				if(a.getTutoria().getProficiencia(disciplina) > tutor.getTutoria().getProficiencia(disciplina)) tutor = a;
				else if(a.getTutoria().getProficiencia(disciplina) == tutor.getTutoria().getProficiencia(disciplina)) {
					if(tutor.getID() > a.getID()) tutor = a;
				}
			}
		}
		return tutor;
	}
	
	/**
	 * Verifica se o Tutor atende no horario e no dia especificados.
	 * @param horario 
	 * @param dia
	 * @return
	 */
	private boolean verificaHorario(Aluno a, String horario, String dia) {
		for (Horario h : a.getHorarios()) {
			if(h.getHorario().equals(dia) && h.getDia().equals(dia)) return true;
		}
		return false;
	}
	
	/**
	 * Método usado para definir o tutor adequado para um pedido de ajuda online.
	 * @param disciplina
	 * 				Disciplina que o Aluno precisa de ajuda
	 * @return matricula do Tutor, uma String.
	 */
	private Aluno tutorAdequado(String disciplina) {
		Aluno tutor = new Aluno(0, "", "", 0, "", "");
		for(Aluno a : mapaAlunos.values()) {
			if(a.isTutor() && a.getTutoria().temDisciplina(disciplina)) {
				if(a.getTutoria().getProficiencia(disciplina) > tutor.getTutoria().getProficiencia(disciplina)) tutor = a;
				else if(a.getTutoria().getProficiencia(disciplina) == tutor.getTutoria().getProficiencia(disciplina)) {
					if(tutor.getID() > a.getID()) tutor = a;
				}
			}
		}
		return tutor;
	}
	
	public int pedirAjudaOnline(String matrAluno, String disciplina) throws Exception {
		String erroPedirAjudaOnline = "Erro no pedido de ajuda online";
		validacoes.matriculaVazia(matrAluno, erroPedirAjudaOnline);
		validacoes.disciplinaVazia(disciplina, erroPedirAjudaOnline);
		pedidos.put(pedidos.size(), new PedidoDeAjudaOnline(tutorAdequado(disciplina), matrAluno, disciplina));
		return pedidos.size() - 1;
	}
	
	public String pegarTutor(int idAjuda) {return pedidos.get(idAjuda).getTutor().toString();}
	
	public String getInfoAjuda(int idAjuda, String atributo) throws Exception {
		String erroGetInfoAjuda = "Erro ao tentar recuperar info da ajuda :";
		validacoes.idAjudaInvalido(idAjuda, pedidos, erroGetInfoAjuda);
		validacoes.atributoVazio(atributo, erroGetInfoAjuda);
		switch (atributo.toLowerCase()) {
		default:
			return pedidos.get(idAjuda).toString();
		case "tutor":
			return pedidos.get(idAjuda).toString() + " - Matricula do tutor:" + this.pegarTutor(idAjuda);
		case "horario":
			return pedidos.get(idAjuda).getInfoAjuda("horario");
		case "dia":
			return pedidos.get(idAjuda).getInfoAjuda("dia");
		case "localInteresse":
			return pedidos.get(idAjuda).getInfoAjuda("localInteresse");
		}
	}
	
	public void avaliarTutor(int idAjuda, int nota) {
		pedidos.get(idAjuda).getTutor().setNotaDeAvaliacao(nota);
	}
	
	public double pegarNota(String matriculaTutor) {
		double notaDoTutor = 0;	
		Aluno alunoPossivelTutor = mapaAlunos.get(matriculaTutor);
		if(alunoPossivelTutor.isTutor()) notaDoTutor = alunoPossivelTutor.getNotaDeAvaliacao();
		return notaDoTutor;
	}
	
	public String pegarNivel(String matriculaTutor) {
		String nivelDoTutor = "";
		double notaDoTutor = pegarNota(matriculaTutor);
		if(notaDoTutor > 4.5) nivelDoTutor = "TOP";
		else if(notaDoTutor > 3 && notaDoTutor <= 4.5) nivelDoTutor = "Tutor";
		else if(0 < notaDoTutor && notaDoTutor > 3.0) nivelDoTutor = "Aprendiz";
		return nivelDoTutor;
	}
}