package quemMeAjuda2.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Comparable<Aluno> {
	private String matricula, nome, email, telefone;
	private int codigoCurso;
	private double notaDeAvaliacao;
	private double bolsa;
	private Tutoria tutoria;
	private List<String> locais, disciplinas;
	private List<Horario> horarios;
	
			
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.email = email;
		this.telefone = telefone;
		this.notaDeAvaliacao = 5.0;
		this.tutoria = null;
	}
	
	public void tornaAlunoTutor(String disciplina, int proficiencia) {
		this.tutoria = new Tutoria(disciplina, proficiencia);
		this.disciplinas = new ArrayList<>();
		disciplinas.add(disciplina);
		this.horarios = new ArrayList<>();
		this.locais = new ArrayList<>();
		this.bolsa = 0.0;
		this.notaDeAvaliacao = 4.0;
	}

	public String getMatricula() {return matricula;}

	public String getNome() {return nome;}

	public String getEmail() {return email;}

	public String getTelefone() {return telefone;}

	public int getCodigoCurso() {return codigoCurso;}
	
	public Tutoria getTutoria() {return tutoria;}
	
	public double getBolsa() {return bolsa;}
	
	public List<String> getLocais() {return locais;}

	public List<String> getDisciplinas() {return disciplinas;}

	public List<Horario> getHorarios() {return horarios;}

	public double getNotaDeAvaliacao() {return notaDeAvaliacao;}
	
	public void setNotaDeAvaliacao(double novaNota) {
		this.notaDeAvaliacao = novaNota;
	}
	
	@Override
	public String toString() {
		if (telefone.trim().isEmpty()) return matricula + " - " + nome + " - " + codigoCurso + " - " +  email;
		return matricula + " - " + nome + " - " + codigoCurso + " - " + telefone + " - " +  email;
	}
	
	@Override
	public int compareTo(Aluno outroAluno) {
		return getNome().compareTo(outroAluno.getNome());
	}
}