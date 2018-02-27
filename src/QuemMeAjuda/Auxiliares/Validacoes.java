package QuemMeAjuda.Auxiliares;

import java.util.List;
import java.util.Map;

import QuemMeAjuda.Entidades.Aluno;

public class Validacoes {
		
	public void nomeInvalidoOuNulo(String nome, String msg) throws Exception {
		if(nome == null) throw new DadoNuloException(msg + "Nome nao pode ser vazio ou nulo");
		if(nome.trim().isEmpty()) throw new DadoInvalidoException(msg + "Nome nao pode ser vazio ou nulo");
	}

	public void emailInvalidoOuNulo(String email, String msg) throws Exception {
		if(email == null) throw new DadoNuloException(msg + "Email invalido");
		int a = 0;
		boolean erro = false;
		if(email.trim().isEmpty()) erro = true;
		else if(!email.contains("@")) erro = true;
		else {
			a = email.indexOf("@");
			if(a == 0 || a == email.length() - 1) erro = true;
		}
		if(erro) throw new DadoInvalidoException(msg + "Email invalido");
	}
	public void tutorNaoCadastrado(String matricula, Map<String, Aluno> alunos, String msg) throws Exception {
		if(!alunos.containsKey(matricula)) throw new DadoInvalidoException(msg + "Tutor nao encontrado");
	}
	
	public void disciplinaJaEhTutor(String disciplina, List<String> disciplinas, String msg) throws Exception {
		if(disciplinas.contains(disciplina)) throw new DadoInvalidoException(msg + "Ja eh tutor dessa disciplina"); 
	}
	
	public void proficienciaInvalida(int proficiencia, String msg) throws Exception{
		if(proficiencia < 0 || proficiencia > 5) throw new DadoInvalidoException(msg + "Proficiencia invalida");
	}
	
	public void horarioInvalido(String horario, String dia, String msg) throws Exception {
		if(horario == null || dia == null) throw new DadoNuloException(msg);
		if(horario.trim().isEmpty() || dia.trim().isEmpty()) throw new DadoInvalidoException(msg);
	}
	
	public void matriculaJaCadastrada(String matricula, Map<String, Aluno> alunos, String msg) throws Exception {
		if(alunos.containsKey(matricula)) throw new DadoInvalidoException(msg + "Aluno de mesma matricula ja cadastrado");
	}
	
	public void alunoNaoCadastrado(String matricula, Map<String, Aluno> alunos, String msg) throws Exception {
		if(!alunos.containsKey(matricula)) throw new DadoInvalidoException(msg + "Aluno nao encontrado");
	}
}