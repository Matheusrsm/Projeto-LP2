package QuemMeAjuda.Auxiliares;

import java.util.Map;

import QuemMeAjuda.Entidades.Aluno;

public class Validacoes {
		
	public void validaNome(String nome) throws Exception {
		if(nome == null) throw new DadoNuloException("Nome nao pode ser vazio ou nulo");
		if(nome.trim().isEmpty()) throw new DadoInvalidoException("Nome nao pode ser vazio ou nulo");
	}

	public void validaEmail(String email) throws Exception {
		if(email == null) throw new DadoNuloException("Email invalido");
		int a = 0;
		boolean erro = false;
		if(email.trim().isEmpty()) erro = true;
		else if(!email.contains("@")) erro = true;
		else a = email.indexOf("@");
		if(a == 0 || a == email.length() - 1) erro = true;
		if(erro) throw new DadoInvalidoException("Email invalido");
	}
	
	public void validaProficiencia(int proficiencia, String msg) throws Exception{
		if(proficiencia < 0 || proficiencia > 5) throw new DadoInvalidoException(msg);
	}
	
	public void validaHorario(String horario, String dia, String msg) throws Exception {
		if(horario == null || dia == null) throw new DadoNuloException(msg);
		if(horario.trim().isEmpty() || dia.trim().isEmpty()) throw new DadoInvalidoException(msg);
	}
	
	public void validaMatricula(String matricula, Map<String, Aluno> alunos) throws Exception {
		/*if(matricula == null) throw new DadoNuloException(msg);
		if(matricula.trim().isEmpty()) throw new DadoInvalidoException(msg);*/
		if(alunos.containsKey(matricula)) throw new DadoInvalidoException("Aluno de mesma matricula ja cadastrado");
	}
	
	public void validaMatriculaJaCadastrada(String matricula, Map<String, Aluno> alunos) throws Exception {
		if(!alunos.containsKey(matricula)) throw new DadoInvalidoException("Aluno nao encontrado");
	}
}