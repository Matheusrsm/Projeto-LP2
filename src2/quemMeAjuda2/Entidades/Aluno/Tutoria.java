package quemMeAjuda2.Entidades.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Tutoria {

	private List<Disciplina> disciplinas;
	private List<String> locais;
	private List<Horario> horarios;
	private double notaDeAvaliacao;
	private double  bolsa;
	
	public Tutoria(String disciplina, int proficiencia) {
		this.disciplinas.add(new Disciplina(disciplina, proficiencia));
		this.locais = new ArrayList<>();
		this.horarios = new ArrayList<>();
		this.notaDeAvaliacao = 4.0;
	}
	
	public void adicionarDisciplina(String disciplina, int proficiencia) {
		disciplinas.add(new Disciplina(disciplina, proficiencia));
	}
	

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public List<String> getLocais() {
		return locais;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public double getNotaDeAvaliacao() {
		return notaDeAvaliacao;
	}

	public double getBolsa() {
		return bolsa;
	}
}