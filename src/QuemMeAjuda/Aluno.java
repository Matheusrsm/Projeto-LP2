package QuemMeAjuda;

import exceptions.DadoInvalidoException;

/**
 * Representação de um aluno, todo aluno deve ter um nome, código do curso e email.
 * O telefone é opcional.
 * Todo aluno possui uma nota de avaliação entre 0 e 5, que se inicia com 5 e muda de acordo com as avaliações.
 * 
 * @author Wesley Monte
 *
 */
public class Aluno {
	private DadoInvalidoException exc;
	private String matricula, nome, email, telefone;
	private int codigoCurso;
	protected double notaDeAvaliacao;
		
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.email = email;
		this.telefone = telefone;
		this.notaDeAvaliacao = 5.0;
	}

	@Override
	public String toString() {
		if (telefone == null) return matricula + " " + nome + " " + codigoCurso + " " +  email;
		else return matricula + " " + nome + " " + codigoCurso + " " + telefone + " " +  email;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public double getNotaDeAvaliacao() {
		return notaDeAvaliacao;
	}
	
	public void setNotaDeAvaliacao(double novaNota) {
		this.notaDeAvaliacao = novaNota;
	}
}