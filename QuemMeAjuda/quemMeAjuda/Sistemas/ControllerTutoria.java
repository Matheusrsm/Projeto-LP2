package quemMeAjuda.Sistemas;

import java.util.HashMap;
import java.util.Map;

import quemMeAjuda.Entidades.Aluno.*;
import quemMeAjuda.Entidades.PedidoDeAjuda.*;
import quemMeAjuda.Excecoes.Validacoes;

/**
 * Classe SistemaTutoria. A classe SistemaTutoria implementa os métodos da interface Sistema
 * em vista de divisão de código e trabalho das classes
 * 
 * @author Lukas Nascimento, Matheus Silva, Wesley Monte
 *
 */
public class ControllerTutoria {
	private Map<String, Aluno> mapaAlunos;
	private Map<Integer, PedidoDeAjuda> pedidos;
	private int caixa;
	private Validacoes validacoes;
	
	public ControllerTutoria() {
		this.mapaAlunos = ControllerAlunos.getAlunos();
		this.pedidos = new HashMap<>();
		this.caixa = 0;
		this.validacoes = new Validacoes();
	}
	
	public String pegaTutor(int idAjuda) throws Exception {
		String erroPegaTutor = "Erro ao tentar recuperar tutor : ";
		validacoes.idAjudaInvalido(idAjuda, pedidos, erroPegaTutor);
		return pedidos.get(idAjuda).toString();
	}

	public int getCaixa() {
		return caixa;
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
		pedidos.put(pedidos.size() + 1, new PedidoDeAjudaPresencial(tutorAdequado(disciplina, horario, dia, localInteresse), matrAluno, disciplina, horario, dia, localInteresse));
		return pedidos.size();
		
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
		tutor.tornaAlunoTutor("", 0);
		for(Aluno a : mapaAlunos.values()) {
			if(a.isTutor() && a.getTutoria().temDisciplina(disciplina) && verificaHorario(a, horario, dia) && a.getTutoria().getLocais().contains(localInteresse)) {
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
		for(Horario h : a.getTutoria().getHorarios()) {
			if(h.getHorario().equals(horario) && h.getDia().equals(dia)) return true;
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
		tutor.tornaAlunoTutor("", 0);
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
		String erroPedirAjudaOnline = "Erro no pedido de ajuda online: ";
		validacoes.matriculaVazia(matrAluno, erroPedirAjudaOnline);
		validacoes.disciplinaVazia(disciplina, erroPedirAjudaOnline);
		pedidos.put(pedidos.size() + 1, new PedidoDeAjudaOnline(tutorAdequado(disciplina), matrAluno, disciplina));
		return pedidos.size();
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) throws Exception {
		String erroGetInfoAjuda = "Erro ao tentar recuperar info da ajuda : ";
		validacoes.idAjudaInvalido(idAjuda, pedidos, erroGetInfoAjuda);
		validacoes.atributoInvalido(atributo, erroGetInfoAjuda);
		return pedidos.get(idAjuda).getInfoAjuda(atributo);
	}
	
	public void avaliarTutor(int idAjuda, int nota) throws Exception {
		String erroAvaliarTutor = "Erro na avaliacao de tutor: ";
		validacoes.notaInvalida(nota, erroAvaliarTutor);
		validacoes.idAjudaInvalido(idAjuda, pedidos, erroAvaliarTutor);
		validacoes.ajudaJaFechada(idAjuda, pedidos, erroAvaliarTutor);
		pedidos.get(idAjuda).getTutor().getTutoria().setNotaDeAvaliacao(nota);
		pedidos.get(idAjuda).setFinalizacao(true);
	}
	
	private double calculaTaxaTutor(String matriculaTutor) {
		Aluno tutor = mapaAlunos.get(matriculaTutor);
		double taxa = 0;
		if(tutor.isTutor())
			if(tutor.getTutoria().getNivel().equals("TOP")) {
				double valorAMais = tutor.getTutoria().getNotaDeAvaliacao() - 4.5;
				taxa = 0.9 + (valorAMais / 10);
			}
			else if(tutor.getTutoria().getNivel().equals("Tutor")) {
				taxa = 0.8;
			}
			else if(tutor.getTutoria().getNivel().equals("Aprendiz")) {
				double valorAMenos = 3.0 - tutor.getTutoria().getNotaDeAvaliacao();
				taxa = 0.4 - (valorAMenos / 10);
			}
		return taxa;
	}
	
	public void doar(String matriculaTutor, int totalCentavos) throws Exception {
		String erroDoar = "Erro na doacao para tutor: ";
		validacoes.totalCentavosInvalido(totalCentavos, erroDoar);
		validacoes.naoEhTutor(matriculaTutor, mapaAlunos, erroDoar);
		double totalSistema = Math.ceil((1 - calculaTaxaTutor(matriculaTutor)) * totalCentavos);
		this.caixa += totalSistema;
		mapaAlunos.get(matriculaTutor).getTutoria().recebeDoacao(totalCentavos - totalSistema);
	}
}	