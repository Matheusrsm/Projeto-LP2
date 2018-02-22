import java.util.HashMap;
import java.util.Map;
/**
 * Sistema Central
 * 
 * @author Wesley Monte
 *
 */
public class Sistema {
	private Map<String, Aluno> alunos = new HashMap<>();
	
	/**
	 * Cadastra um aluno no sistema que será identificado por sua matrícula.
	 * @param nome nome do aluno
	 * @param matricula matricula do aluno
	 * @param codigoCurso inteiro que representa o código do curso
	 * @param telefone telefone do aluno
	 * @param email email do aluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}
	
	/**
	 * Retorna a representação textual de um aluno.
	 * @param matricula matricula do aluno
	 * @return Representação textual do aluno
	 */
	public String recuperaAluno(String matricula) {
		return alunos.get(matricula).toString();
	}
	
	/**
	 * Retorna a representação textual de todos os alunos do sistema
	 * @return representação textual de todos os alunos
	 */
	public String listarAlunos() {
		String listaAlunos = "";
		for(Aluno a: alunos.values()) {
			listaAlunos += a.toString() + System.lineSeparator();
		}
		listaAlunos = listaAlunos.substring(0, listaAlunos.length() - 1);
		return listaAlunos;
	}
	
	/**
	 * Retorna o atributo pedido do aluno
	 * @param matricula matriula do aluno 
	 * @param atributo atributo desejado do aluno
	 * @return representação textual do atributo
	 */
	public String getInfoAluno(String matricula, String atributo) {
		switch (atributo){
			case "nome":
				return alunos.get(matricula).getNome();
			case "codigo do curso":
				return Integer.toString(alunos.get(matricula).getCodigoCurso());
			case "telefone":
				return alunos.get(matricula).getTelefone();
			case "email":
				return alunos.get(matricula).getEmail();
			default:
				return null;
		}
	}
	
}
