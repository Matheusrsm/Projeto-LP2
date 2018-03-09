package quemMeAjuda.Sistemas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Comparadores.ComparadorEmail;
import Comparadores.ComparadorMatricula;
import Comparadores.ComparadorNome;
import quemMeAjuda.Entidades.Aluno.*;
import quemMeAjuda.Excecoes.Validacoes;

public class ControllerAlunos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5902969503242499205L;
	private static Map<String, Aluno> alunos;
	private Validacoes validacoes;
	private Comparator<Aluno> ordem;
	
	public ControllerAlunos() {
		ControllerAlunos.alunos = new HashMap<>();
		this.validacoes = new Validacoes();
		this.ordem = new ComparadorNome();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) throws Exception {
		String erroCadastrarAluno = "Erro no cadastro de aluno: ";
		validacoes.emailInvalidoOuNulo(email, erroCadastrarAluno);
		validacoes.matriculaJaCadastrada(matricula, alunos, erroCadastrarAluno);
		validacoes.nomeInvalidoOuNulo(nome, erroCadastrarAluno);
		alunos.put(matricula, new Aluno(alunos.size() + 1, nome, matricula, codigoCurso, telefone, email));
	}
	
	public String recuperaAluno(String matricula) throws Exception {
		String erroRecuperaAluno = "Erro na busca por aluno: ";
		validacoes.alunoNaoCadastrado(matricula, alunos, erroRecuperaAluno);
		return alunos.get(matricula).toString();
	}
	
	public String listarAlunos() {
		List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
		for(Aluno a: alunos.values()) listaDeAlunos.add(a);
		Collections.sort(listaDeAlunos, this.ordem);
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
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws Exception {
		String erroTornarTutor = "Erro na definicao de papel: ";
		validacoes.disciplinaVazia(disciplina, erroTornarTutor);
		validacoes.naoEhTutor(matricula, alunos, erroTornarTutor);
		Aluno alunoViraTutor = alunos.get(matricula);
		if(alunoViraTutor.isTutor()) {
			List<Disciplina> disciplinasDoTutor = alunoViraTutor.getTutoria().getDisciplinas();
			validacoes.disciplinaJaEhTutor(disciplina, disciplinasDoTutor, erroTornarTutor);
			validacoes.proficienciaInvalida(proficiencia, erroTornarTutor);
			alunoViraTutor.getTutoria().adicionarDisciplina(disciplina, proficiencia);
		}
		else alunoViraTutor.tornaAlunoTutor(disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) throws Exception {
		String erroRecuperaTutor = "Erro na busca por tutor: ";
		validacoes.naoEhTutor(matricula, alunos, erroRecuperaTutor);
		if(alunos.get(matricula).isTutor()) return alunos.get(matricula).toString();
		return null;
	}
	
	public String listarTutores() {
		ArrayList<Aluno> listaDeTutores = new ArrayList<Aluno>();
		for(Aluno aluno: alunos.values())
			if(aluno.isTutor()) listaDeTutores.add(aluno);
		Collections.sort(listaDeTutores, this.ordem);
		String listaTutores = "";
		for(Aluno aluno: listaDeTutores) listaTutores += aluno.toString() + ", ";
		return listaTutores.substring(0, listaTutores.length() - 2);
	}
	
	private boolean verificaEmailETutoria(String email, Aluno aluno) {
		return aluno.getEmail().equals(email) && aluno.isTutor();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) throws Exception {
		String erroCadastrarHorario = "Erro no cadastrar horario: ";
		validacoes.emailInvalidoOuNulo(email, erroCadastrarHorario);
		validacoes.horarioInvalido(horario, dia, erroCadastrarHorario);
		validacoes.tutorEmailNaoCadastrado(email, alunos, erroCadastrarHorario + "tutor nao cadastrado");
		for(Aluno aluno : alunos.values())
			if(verificaEmailETutoria(email, aluno)) 
				aluno.getTutoria().getHorarios().add(new Horario(horario, dia));
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) throws Exception {
		String erroCadastrarLocal = "Erro no cadastrar local de atendimento: ";
		validacoes.localInvalidoOuNulo(local, erroCadastrarLocal);
		validacoes.emailInvalidoOuNulo(email, erroCadastrarLocal);
		validacoes.tutorEmailNaoCadastrado(email, alunos, erroCadastrarLocal + "tutor nao cadastrado");
		for(Aluno aluno : alunos.values())
			if(verificaEmailETutoria(email, aluno))
					aluno.getTutoria().getLocais().add(local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		for(Aluno aluno : alunos.values())
			if(verificaEmailETutoria(email, aluno))
				for(Horario h : aluno.getTutoria().getHorarios())
					if(h.getDia().equalsIgnoreCase(dia) && h.getHorario().equalsIgnoreCase(horario)) 
						return true;
		return false;
	}
	
	public boolean consultaLocal(String email, String local) {
		for(Aluno aluno : alunos.values())
			if(verificaEmailETutoria(email, aluno))
				return aluno.getTutoria().getLocais().contains(local);
		return false;
	}
	
	public String pegarNota(String matriculaTutor) {
		Aluno alunoPossivelTutor = alunos.get(matriculaTutor);
		if(alunoPossivelTutor.isTutor()) return alunoPossivelTutor.getTutoria().toStringNotaDeAvaliacao();
		return null;
	}
	
	public String pegarNivel(String matriculaTutor) {
		alunos.get(matriculaTutor).getTutoria().setNivel();
		return alunos.get(matriculaTutor).getTutoria().getNivel();
	}
	
	public int totalDinheiroTutor(String emailTutor) throws Exception {
		String erroTotalDinheiroTutor = "Erro na consulta de total de dinheiro do tutor: ";
		validacoes.emailTutorInvalidoOuNulo(emailTutor, erroTotalDinheiroTutor);
		validacoes.tutorEmailNaoCadastrado(emailTutor, alunos, erroTotalDinheiroTutor + "Tutor nao encontrado");
		for(Aluno a:alunos.values())
			if(a.isTutor() && a.getEmail().equals(emailTutor))
				return (int) a.getTutoria().getBolsa();
		return 0;
	}
	
	public void configurarOrdem(String atributo) {
		if(atributo.equals("NOME")) this.ordem = new ComparadorNome();
		else if(atributo.equals("MATRICULA")) this.ordem = new ComparadorMatricula();
		else if(atributo.equals("EMAIL")) this.ordem = new ComparadorEmail();
	}

	public static Map<String, Aluno> getAlunos() {
		return alunos;
	}
}