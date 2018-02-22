
public class Aluno {
	
	String matricula, nome, email, telefone;
	int codigoCurso;
	double notaDeAvaliacao;
	
	public Aluno(String matricula, String nome, int codigoCurso, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.codigoCurso = codigoCurso;
		this.email = email;
	}
	
	public Aluno(String matricula, String nome, int codigoCurso, String email, String telefone) {
		this.matricula = matricula;
		this.nome = nome;
		this.codigoCurso = codigoCurso;
		this.email = email;
		this.telefone = telefone;
	}
}
