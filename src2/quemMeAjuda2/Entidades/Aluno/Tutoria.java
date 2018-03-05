package quemMeAjuda2.Entidades.Aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tutoria {

	private HashMap<String, Disciplina> disciplinas;
	private List<String> locais;
	private List<Horario> horarios;
	private double notaDeAvaliacao;
	private double  bolsa;
	
	public Tutoria(String disciplina, int proficiencia) {
		disciplinas          = new HashMap<>();
		this.disciplinas.put(disciplina.toLowerCase(), new Disciplina(disciplina, proficiencia));
		this.locais          = new ArrayList<>();
		this.horarios        = new ArrayList<>();
		this.notaDeAvaliacao = 4.0;
	}
	
	public void adicionarDisciplina(String disciplina, int proficiencia) {
		disciplinas.put(disciplina.toLowerCase(), new Disciplina(disciplina, proficiencia));
	}
	
	
	public double getProficiencia(String disciplina) {
		return disciplinas.get(disciplina.toLowerCase()).getProficiencia();
	}
	
	public void recebeDoacao(double doacao) {
		this.bolsa += doacao;
	}

	public List<Disciplina> getDisciplinas() {
		return (List<Disciplina>) disciplinas.values();
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