package quemMeAjuda2.Sistema;

import java.util.List;
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
	private Map<String, Aluno> mapaAlunos = SistemaAlunos.getMapaDeAlunos();
	private static List<PedidoDeAjuda> pedidos;
	private Validacoes validacoes = new Validacoes();
	
	
	//***********************************************************************************************************
	/*
	 * Acredito que a partir daqui seria bom por tudo em um outro controle. O novo sistema guardaria a lista de pedidos.
	 * Nesse sistema pode-se adicionar getMapaAluno caso seja necessario usar no novo.
	 * 
	 */
	
	/**
	 * Cria um novo objeto PedidoDeAjudaPresencial e implementa qual tutor está sendo associado ao pedido.
	 * O novo objeto é adicionado à lista de pedidos de ajuda do sistema.
	 * @param matrAluno String
	 *		matricula do tutor a ajudar
	 * @param disciplina String
	 * 		disciplina que o aluno deseja ajuda
	 * @param horario String
	 * 		horario que o aluno contratante quer a ajuda
	 * @param dia String
	 * 		dia que o aluno contratante quer a ajuda
	 * @param localInteresse
	 * 		local que o aluno contratante quer a ajuda
	 * @return
	 * @throws Exception 
	 */
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) throws Exception {
		String erroPedirAjudaPresencial = "Erro no pedido de ajuda presencial: ";
		validacoes.matriculaVaziaOuNula(matrAluno, erroPedirAjudaPresencial);
		validacoes.disciplinaVaziaOuNula(disciplina, erroPedirAjudaPresencial);
		validacoes.horarioVazioOuNulo(horario, erroPedirAjudaPresencial);
		validacoes.diaVazioOuNulo(dia, erroPedirAjudaPresencial);
		validacoes.localVazioOuNulo(localInteresse, erroPedirAjudaPresencial);
		PedidoDeAjudaPresencial pedidoPresencial = new PedidoDeAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
		pedidoPresencial.setTutor(mapaAlunos.get(tutorAdequado(disciplina, horario, dia, localInteresse)));
		pedidos.add(pedidoPresencial);
		return pedidos.indexOf(pedidoPresencial);
		
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
	private String tutorAdequado(String disciplina, String horario, String dia, String localInteresse) {
		//falta definir o que fazer em caso de empate
		String matricula = "";
		for(Aluno a : mapaAlunos.values()) {
			if (matricula.isEmpty() && a.isTutor() && a.getTutoria().temDisciplina(disciplina) && verificaHorario(a, horario, dia) && a.getLocais().contains(localInteresse)) {
				matricula = a.getMatricula();
			}
			else if(a.isTutor() && a.getTutoria().temDisciplina(disciplina) && verificaHorario(a, horario, dia) && a.getLocais().contains(localInteresse) && 
					a.getTutoria().getProficiencia(disciplina) > mapaAlunos.get(matricula).getTutoria().getProficiencia(disciplina)) {
				matricula = a.getMatricula();
			}
		}
		return matricula;
	}
	
	/**
	 * Verifica se o Tutor atende no horario e no dia especificados.
	 * @param horario 
	 * @param dia
	 * @return
	 */
	private boolean verificaHorario(Aluno a, String horario, String dia) {
		for (Horario h : a.getHorarios()) {
			if(h.getHorario().equals(dia) && h.getDia().equals(dia)) {
				return true;
					}
			}
		return false;
	}
	
	/**
	 * Método usado para definir o tutor adequado para um pedido de ajuda online.
	 * @param disciplina
	 * 				Disciplina que o Aluno precisa de ajuda
	 * @return matricula do Tutor, uma String.
	 */
	private String tutorAdequado(String disciplina) {
		//falta definir o que fazer em caso de empate
		String matricula = "";
		for(Aluno a : mapaAlunos.values()) {
			if (matricula.isEmpty() && a.isTutor() && a.getTutoria().temDisciplina(disciplina)) {
				matricula = a.getMatricula();
			}
			else if (a.isTutor() && a.getTutoria().temDisciplina(disciplina) &&
					a.getTutoria().getProficiencia(disciplina) > mapaAlunos.get(matricula).getTutoria().getProficiencia(disciplina)) {
				matricula = a.getMatricula();
			}
		}
		return matricula;
	}
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) throws Exception {
		String erroPedirAjudaOnline = "Erro no pedido de ajuda online";
		validacoes.matriculaVaziaOuNula(matrAluno, erroPedirAjudaOnline);
		validacoes.disciplinaVaziaOuNula(disciplina, erroPedirAjudaOnline);
		PedidoDeAjudaOnline pedidoOnline = new PedidoDeAjudaOnline(matrAluno, disciplina);
		pedidoOnline.setTutor(mapaAlunos.get((this.tutorAdequado(disciplina))));
		pedidos.add(pedidoOnline);
		return pedidos.size();
	}
	
	public String pegarTutor(int idAjuda) {
		return pedidos.get(idAjuda).getTutor().toString();
		
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		switch (atributo.toLowerCase()) {
		default:
			return pedidos.get(idAjuda).toString();
		case "tutor":
			return pedidos.get(idAjuda).toString() + " - Matricula do tutor:" + this.pegarTutor(idAjuda);
		case "infoAjuda":
			return pedidos.get(idAjuda).toString();
		}
		
		
	}
	
	private static List<PedidoDeAjuda> getPedidos(){ return pedidos;}

}