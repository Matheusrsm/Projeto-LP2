package quemMeAjuda2.Entidades.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Tutoria {

	private List<Disciplina> disciplinas;
	private List<String> locais;
	private List<Horario> horarios;
	private double notaDeAvaliacao;
	private double  bolsa;
	private NivelTutoria nivel;
	
	public Tutoria() {
		this.disciplinas = new ArrayList<>();
		this.locais = new ArrayList<>();
		this.horarios = new ArrayList<>();
		this.notaDeAvaliacao = 4.0;
		this.nivel = NivelTutoria.TUTOR;
		this.bolsa = 0.0;
	}
	
	public void adicionarDisciplina(String disciplina, int proficiencia) {
		disciplinas.add(new Disciplina(disciplina, proficiencia));
	}
	
	public double getProficiencia(String disciplina) {
		for (Disciplina d : disciplinas) {
			if (d.getNome().equals(disciplina)) return d.getProficiencia();
		}
		return 0;
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
	
	public void setNotaDeAvaliacao(double novaAvaliacao) {
		this.notaDeAvaliacao = ((notaDeAvaliacao * 5) + novaAvaliacao) / 6;
	}
	
	public String toStringNotaDeAvaliacao() {
		String nota = "" + notaDeAvaliacao;
		String[] notaQuebrada = nota.split(".");
		return notaQuebrada[0] + "," + notaQuebrada[1];
	}

	public double getBolsa() {
		return bolsa;
	}

	public String getNivel() {
		return nivel.getDescricao();
	}

	public void setNivel() {
		if(notaDeAvaliacao > 4.5) this.nivel = NivelTutoria.TOP;
		else if(notaDeAvaliacao > 3.0 && notaDeAvaliacao <= 4.5) this.nivel = NivelTutoria.TUTOR;
		else if(notaDeAvaliacao > 0 && notaDeAvaliacao <= 3.0) this.nivel = NivelTutoria.APRENDIZ;
	}
}