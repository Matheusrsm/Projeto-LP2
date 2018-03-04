package quemMeAjuda2.Auxiliares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import quemMeAjuda2.Entidades.*;
import quemMeAjuda2.validacoes.Validacoes;

public class Sistema {

	private Map<String, Aluno> alunos;
	private Validacoes validacoes;
	
	public Sistema() {
		this.alunos     = new HashMap<>();
		this.validacoes = new Validacoes();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) throws Exception {
		String erroCadastrarAluno = "Erro no cadastro de aluno: ";
		validacoes.matriculaJaCadastrada(matricula, alunos, erroCadastrarAluno);
		validacoes.nomeInvalidoOuNulo(nome, erroCadastrarAluno);
		validacoes.emailInvalidoOuNulo(email, erroCadastrarAluno);
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}
	
	public String recuperaAluno(String matricula) throws Exception {
		String erroRecuperaAluno = "Erro na busca por aluno: ";
		validacoes.alunoNaoCadastrado(matricula, alunos, erroRecuperaAluno);
		return alunos.get(matricula).toString();
	}
	
	public String listarAlunos() {
		List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
		for(Aluno a: alunos.values()) listaDeAlunos.add(a);
		Collections.sort(listaDeAlunos, new ComparadorNomeAluno());
		String listaAlunos = "";
		for(Aluno a: listaDeAlunos) listaAlunos += a.toString() + ", ";
		listaAlunos = listaAlunos.substring(0, listaAlunos.length() - 2);
		return listaAlunos;
	}
	
	public String getInfoAluno(String matricula, String atributo) throws Exception {
		String erroGetInfoAluno = "Erro na obtencao de informacao de aluno: ";
		validacoes.alunoNaoCadastrado(matricula, alunos, erroGetInfoAluno);
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
	 * Se a lista de tutorias estiver vazia, retornará false. I.e., o Aluno não é Tutor;
	 * @param aluno
	 * @return boolean
	 */
	private boolean verificaTutoria(Aluno aluno) {
		return !aluno.getTutorias().isEmpty();
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws Exception {
		String erroTornarTutor = "Erro na definicao de papel: ";
		validacoes.alunoNaoCadastrado(matricula, alunos, erroTornarTutor);
		Aluno alunoViraTutor = alunos.get(matricula);
		if(verificaTutoria(alunoViraTutor)) {
			List<String> disciplinasDoTutor = alunoViraTutor.getDisciplinas();
			validacoes.disciplinaJaEhTutor(disciplina, disciplinasDoTutor, erroTornarTutor);
			validacoes.proficienciaInvalida(proficiencia, erroTornarTutor);
			disciplinasDoTutor.add(disciplina);
		}
		else alunoViraTutor.tornaAlunoTutor(disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) throws Exception {
		String erroRecuperaTutor = "Erro na busca por tutor: ";
		validacoes.alunoNaoCadastrado(matricula, alunos, erroRecuperaTutor);
		if(verificaTutoria(alunos.get(matricula))) return alunos.get(matricula).toString();
		return null;
	}
	
	public String listarTutores() {
		ArrayList<Aluno> listaDeTutores = new ArrayList<Aluno>();
		for(Aluno aluno: alunos.values()) {
			if(verificaTutoria(aluno)) listaDeTutores.add(aluno);
		}
		Collections.sort(listaDeTutores, new ComparadorNomeAluno());
		String listaTutores = "";
		for(Aluno aluno: listaDeTutores) listaTutores += aluno.toString() + ", ";
		return listaTutores.substring(0, listaTutores.length() - 2);
	}
	
	private boolean verificaEmailETutoria(String email, Aluno aluno) {
		return aluno.getEmail().equals(email) && verificaTutoria(aluno);
	}
	
	public void cadastrarHorario(String email, String horario, String dia) throws Exception {
		String erroCadastrarHorario = "Erro no cadastrar horario: ";
		validacoes.emailInvalidoOuNulo(email, erroCadastrarHorario);
		validacoes.horarioInvalido(horario, dia, erroCadastrarHorario);
		validacoes.tutorEmailNaoCadastrado(email, alunos, erroCadastrarHorario);
		for(Aluno aluno : alunos.values())
			if(verificaEmailETutoria(email, aluno)) 
				aluno.getHorarios().add(new Horario(horario, dia));
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) throws Exception {
		String erroCadastrarLocal = "Erro no cadastrar local de atendimento: ";
		validacoes.localInvalidoOuNulo(local, erroCadastrarLocal);
		validacoes.emailInvalidoOuNulo(email, erroCadastrarLocal);
		validacoes.tutorEmailNaoCadastrado(email, alunos, erroCadastrarLocal);
		for(Aluno aluno : alunos.values())
			if(verificaEmailETutoria(email, aluno))
					aluno.getLocais().add(local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		for(Aluno aluno : alunos.values())
			if(verificaEmailETutoria(email, aluno))
				for(Horario h : aluno.getHorarios())
					if(h.getDia().equalsIgnoreCase(dia) && h.getHorario().equalsIgnoreCase(horario)) 
						return true;
		return false;
	}
	
	public boolean consultaLocal(String email, String local) {
		for(Aluno aluno : alunos.values())
			if(verificaEmailETutoria(email, aluno))
				return aluno.getLocais().contains(local);
		return false;
	}














}