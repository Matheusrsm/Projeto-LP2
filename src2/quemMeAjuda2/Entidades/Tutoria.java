package quemMeAjuda2.Entidades;

public class Tutoria {

	private String disciplina; 
	private int proficiencia;
	
	public Tutoria(String disciplina, int proficiencia) {
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(int proficiencia) {
		this.proficiencia = proficiencia;
	}
}