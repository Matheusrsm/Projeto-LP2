package quemMeAjuda2.Sistema;

import java.util.List;
import java.util.Map;

import quemMeAjuda2.Entidades.Aluno.*;
import quemMeAjuda2.Entidades.PedidoDeAjuda.*;

/**
 * Classe SistemaTutoria. A classe SistemaTutoria implementa os métodos da interface Sistema
 * em vista de divisão de código e trabalho das classes
 * 
 * @author Lukas Nascimento
 *
 */
public class SistemaTutoria {
	private Map<String, Aluno> mapaAlunos = SistemaAlunos.getMapaDeAlunos();
	private static List<PedidoDeAjuda> pedidos;
	
	
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
	 */
	public int pedirAjudaPresencial (String matrAluno, String disciplina,
										String horario, String dia, String localInteresse) {
		PedidoDeAjudaPresencial pedidoPresencial = new PedidoDeAjudaPresencial(matrAluno, disciplina,
																			horario, dia, localInteresse);
		//aqui ainda faltam validacoes e comparacoes de tutores para qual possa melhor atender o aluno contratante
		pedidoPresencial.setTutor(mapaAlunos.get(matrAluno));
		pedidos.add(pedidoPresencial);
		return pedidos.indexOf(pedidoPresencial);
		
	}
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		PedidoDeAjudaOnline pedidoOnline = new PedidoDeAjudaOnline(matrAluno, disciplina);
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