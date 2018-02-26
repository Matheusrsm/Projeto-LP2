package QuemMeAjuda;
import java.util.HashMap;
import java.util.Map;

import exceptions.DadoInvalidoException;
import validacao.ValidaAluno;
import validacao.ValidaTutor;


/**
 * Sistema Central
 * 
 * @author Wesley Monte, Matheus Silva, Lukas Nascimento
 *
 */
public class Sistema {
	private Map<String, Aluno> alunos;
	
	public Sistema() {
		alunos = new HashMap<>();
	}
	
	/**
	 * Cadastra um Aluno no sistema que será identificado por sua matrícula.
	 * @param nome 
	 * 		nome do Aluno, no formato String.
	 * @param matricula 
	 * 		matricula do Aluno, no formato String.
	 * @param codigoCurso 
	 * 		inteiro que representa o código do curso.
	 * @param telefone 
	 * 		telefone do Aluno, no formato String.
	 * @param email 
	 * 		email do Aluno, no formato String.
	 * @throws DadoInvalidoException 
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email)
			throws DadoInvalidoException {
		try{
			ValidaAluno.validaNome(nome);
			ValidaAluno.validaEmail(email);
		}catch(DadoInvalidoException e) {
			throw new DadoInvalidoException("Erro no cadastro de aluno: " + e.getMessage());
		}
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}
	
	/**
	 * @param matricula 
	 * 		matricula do Aluno, no formato String.
	 * @return Representação textual do Aluno.
	 */
	public String recuperaAluno(String matricula) {
		return alunos.get(matricula).toString();
	}
	
	/**
	 * @return representação textual de todos os Alunos cadastrados.
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
	 * @param matricula 
	 * 		matricula do Aluno, no formato String.
	 * @param atributo 
	 * 		atributo desejado do Aluno, no formato String.
	 * @return representação textual do atributo do Aluno.
	 */
	public String getInfoAluno(String matricula, String atributo) {
		switch (atributo.toLowerCase()){
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
	
	/**
	 * Torna o Aluno um Tutor
	 * @param matricula
	 * 		matricula do Aluno que se tornará Tutor, no formato String.
	 * @param disciplina
	 * 		disciplina que o Aluno será o Tutor, no formato String.
	 * @param proficiencia
	 * 		valor inteiro que define o quão hábil na disciplina o Aluno é.
	 * @throws DadoInvalidoException 
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws DadoInvalidoException {
		ValidaTutor.validaProficiencia(proficiencia);
		Aluno alunoViraTutor = alunos.get(matricula);
		Aluno alunoTutor = new Tutor(alunoViraTutor.getNome(), alunoViraTutor.getMatricula(), alunoViraTutor.getCodigoCurso(), 
									alunoViraTutor.getTelefone(), alunoViraTutor.getEmail(), disciplina, proficiencia);
		alunos.remove(matricula);
		alunos.put(matricula, alunoTutor);
	}
	
	/**
	 * 
	 * @param matricula
	 * 		matricula do Tutor procurado, no formato String.
	 * @return o Tutor procurado.
	 */
	public Aluno recuperaTutor(String matricula) {
		return alunos.get(matricula);
	}
	
	/**
	 * @return representação textual de todos os Tutores cadastrados.
	 */
	public String listarTutores() {
		String listaTutores = "";
		for(Aluno a: alunos.values()) {
			if(a instanceof Tutor) {
				listaTutores += a.toString() + System.lineSeparator();
			}
		}
		return listaTutores;
	}
	
	/**
	 * Cadastro de um objeto Horario (que representa o horario de atendimento) do Tutor,
	 * localizado pelo email.
	 * @param email 
	 * 		String email do tutor
	 * @param horario
	 * 		String horario a cadastrar
	 * @param dia
	 * 		String dia a cadastrar
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		for(Aluno i : alunos.values())
			if (i.getEmail().equals(email))
				if (i instanceof Tutor)
					((Tutor) i).cadastrarHorario(horario, dia);
		
	}
	
	/**
	 * Cadastro de local para atendimento de um Tutor. O local não está relacionado aos horarios do Tutor.
	 * @param email
	 * 		String email do Tutor
	 * @param local
	 * 		String local de atendimento do Tutor
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		for(Aluno i : alunos.values())
			if (i.getEmail().equals(email))
				if (i instanceof Tutor)
					((Tutor) i).cadastrarLocal(local);
	}

	/**
	 * Consulta de Horario de um tutor
	 * @param email
	 * 		String email do Tutor
	 * @param horario
	 * 		String horario de atendimento do Tutor a ser verificado
	 * @param dia
	 * 		String dia de atendimento do Tutor a ser verificado
	 * @return
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		Horario hora = new Horario(horario, dia);
		for(Aluno i : alunos.values())
			if (i.getEmail().equals(email))
				if (i instanceof Tutor)
					for (Horario x : ((Tutor) i).getHorarios())
						if (x.equals(hora))
							return true;
		return false;
	}
	
	/**
	 * Consulta de um local de atendimento de um Tutor
	 * @param email
	 * 		String email do Tutor
	 * @param local
	 * 		String local de atendimento a ser verificado de um Tutor
	 * @return
	 */
	public boolean consultaLocal(String email, String local) {
		for(Aluno i : alunos.values())
			if (i.getEmail().equals(email))
				if (i instanceof Tutor)
					for (String x : ((Tutor) i).getLocais())
						if (x.equals(local))
							return true;
		return false;
	}






}