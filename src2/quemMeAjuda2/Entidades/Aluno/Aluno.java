package quemMeAjuda2.Entidades.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Comparable<Aluno> {
	private String  matricula, nome, email, telefone;
	private int     codigoCurso;
	private double  notaDeAvaliacao;
	private static Tutoria tutoria;
	
			
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.nome        = nome;
		this.matricula   = matricula;
		this.codigoCurso = codigoCurso;
		this.email       = email;
		this.telefone    = telefone;
		notaDeAvaliacao  = 5.0;
		tutoria          = null;
	}
	
	public void tornaAlunoTutor(String disciplina, int proficiencia) {
		tutoria = new Tutoria(disciplina, proficiencia);
		notaDeAvaliacao = 4.0;
	}
	
	public boolean isTutor() {
		if (tutoria == null)
			return false;
		return true;
	}
	
	public List<String> getDisciplinas() {
		List<String> disciplinas = new ArrayList<>();
		if (isTutor()) 
			for (Disciplina d  : tutoria.getDisciplinas())
				disciplinas.add(d.getNome());
		return disciplinas;
	}
	
	public String getMatricula() {return matricula;}

	public String getNome() {return nome;}

	public String getEmail() {return email;}

	public String getTelefone() {return telefone;}

	public int getCodigoCurso() {return codigoCurso;}
	
	public Tutoria getTutoria() {return tutoria;}
	
	public double getBolsa() {return tutoria.getBolsa();}
	
	public List<String> getLocais() {return tutoria.getLocais();}

	public List<Horario> getHorarios() {return tutoria.getHorarios();}

	public double getNotaDeAvaliacao() {return notaDeAvaliacao;}
	
	public void setNotaDeAvaliacao(double novaNota) {this.notaDeAvaliacao = novaNota;}
	
	@Override
	public String toString() {
		if (telefone.trim().isEmpty()) return matricula + " - " + nome + " - " + codigoCurso + " - " +  email;
		return matricula + " - " + nome + " - " + codigoCurso + " - " + telefone + " - " +  email;
	}
	
	@Override
	public int compareTo(Aluno outroAluno) {return getNome().compareTo(outroAluno.getNome());}
}