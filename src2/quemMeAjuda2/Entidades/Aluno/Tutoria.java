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
		disciplinas          = new ArrayList<>();
		this.disciplinas.add(new Disciplina(disciplina, proficiencia));
		this.locais          = new ArrayList<>();
		this.horarios        = new ArrayList<>();
		this.notaDeAvaliacao = 4.0;
	}
	
	public void adicionarDisciplina(String disciplina, int proficiencia) {
		disciplinas.add(new Disciplina(disciplina, proficiencia));
	}
	
	// Falta lançar uma exceção quando a disciplina nãoo existir
	public double getProficiencia(String disciplina) {
		for (Disciplina d : disciplinas) {
			if (d.getNome().equals(disciplina)) return d.getProficiencia();
		}
		return 0.0;
	}
	
	/**
	 * Método que verifica se o tutor tem a disciplina passada
	 * @param disciplina
	 * 				Disciplina a ser consultada
	 * @return Um booleano 
	 */
	public boolean temDisciplina(String disciplina) {
		for (Disciplina d : disciplinas) {
			if (d.getNome().equals(disciplina)) return true;
		}
		return false;
	}
	
	public void recebeDoacao(double doacao) {
		this.bolsa += doacao;
	}

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
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