package quemMeAjuda2.Entidades.Aluno;

public class Aluno implements Comparable<Aluno> {
	private String  matricula, nome, email, telefone;
	private int     codigoCurso, iD;
	private double  notaDeAvaliacao;
	private Tutoria tutoria;
	
			
	public Aluno(int iD, String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.iD = iD;
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.email = email;
		this.telefone = telefone;
		this.notaDeAvaliacao = 5.0;
	}
	
	public void tornaAlunoTutor(String disciplina, int proficiencia) {
		tutoria = new Tutoria();
		tutoria.adicionarDisciplina(disciplina, proficiencia);
	}
	
	public boolean isTutor() {
		if (tutoria == null)
			return false;
		return true;
	}
	
	public String getMatricula() {return matricula;}

	public String getNome() {return nome;}

	public String getEmail() {return email;}

	public String getTelefone() {return telefone;}

	public int getCodigoCurso() {return codigoCurso;}
	
	public Tutoria getTutoria() {return tutoria;}

	public double getNotaDeAvaliacao() {return notaDeAvaliacao;}
	
	public void setNotaDeAvaliacao(double novaNota) {this.notaDeAvaliacao = novaNota;}
	
	public int getID() {return iD;}
	
	@Override
	public String toString() {
		if (telefone.trim().isEmpty()) return matricula + " - " + nome + " - " + codigoCurso + " - " +  email;
		return matricula + " - " + nome + " - " + codigoCurso + " - " + telefone + " - " +  email;
	}
	
	@Override
	public int compareTo(Aluno outroAluno) {return getNome().compareTo(outroAluno.getNome());}

}