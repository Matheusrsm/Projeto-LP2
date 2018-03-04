package quemMeAjuda2.Entidades.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Comparable<Aluno> {
	private String  matricula, nome, email, telefone;
	private int     codigoCurso;
	private double  notaDeAvaliacao;
	private double  bolsa;
	private static List<Tutoria> tutorias;
	private List<String> locais;
	private List<Horario> horarios;
	
			
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.nome        = nome;
		this.matricula   = matricula;
		this.codigoCurso = codigoCurso;
		this.email       = email;
		this.telefone    = telefone;
		notaDeAvaliacao  = 5.0;
		tutorias         = null;
	}
	
	public void tornaAlunoTutor(String disciplina, int proficiencia) {
		tutorias = new ArrayList<>();
		tutorias.add(new Tutoria(disciplina, proficiencia));
		horarios = new ArrayList<>();
		locais   = new ArrayList<>();
		bolsa    = 0.0;
		notaDeAvaliacao = 4.0;
	}
	
	public boolean isTutor() {
		if (tutorias == null)
			return false;
		return true;
	}
	
	public List<String> getDisciplinas() {
		List<String> disciplinas = new ArrayList<>();
		if (isTutor()) 
			for (Tutoria i : tutorias)
				disciplinas.add(i.getDisciplina());
		return disciplinas;
	}
	
	public String getMatricula() {return matricula;}

	public String getNome() {return nome;}

	public String getEmail() {return email;}

	public String getTelefone() {return telefone;}

	public int getCodigoCurso() {return codigoCurso;}
	
	public List<Tutoria> getTutorias() {return tutorias;}
	
	public double getBolsa() {return bolsa;}
	
	public List<String> getLocais() {return locais;}

	public List<Horario> getHorarios() {return horarios;}

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