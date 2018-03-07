package quemMeAjuda.Entidades.Aluno;

public class Disciplina {
	private String nome;
	private double proficiencia;
	
	public Disciplina(String nome, double proficiencia) {
		this.nome = nome;
		this.proficiencia = proficiencia;
	}

	public String getNome() {
		return nome;
	}

	public double getProficiencia() {
		return proficiencia;
	}
}
