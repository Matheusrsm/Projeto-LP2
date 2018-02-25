package QuemMeAjuda;

import java.util.HashSet;

/**
 * Representação de um tutor que é um aluno.
 * Todo tutor deve ter uma disciplina, uma proficiencia entre 1 e 5 e uma bolsa que se inicia em 0.
 * Todo tutor possui uma nota de avaliação entre 0 e 5, que se inicia com 4 e muda de acordo com as avaliações.
 * 
 * @author Matheus Silva, Lukas Nascimento
 *
 */
public class Tutor extends Aluno {
	private HashSet<String> locais;
	private HashSet<Horario> horarios;
	private String disciplina;
	private int proficiencia; 
	private double bolsa;
	
	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, 
				 String email, String disciplina, int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, email);
		this.proficiencia = proficiencia;
		this.disciplina = disciplina;
		this.bolsa = 0.0;
		this.notaDeAvaliacao = 4.0;
		locais = new HashSet<>();
		horarios = new HashSet<>();
	}

	public String getDisciplina() {
		return disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public double getBolsa() {
		return bolsa;
	}

	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}
	
	public void cadastrarLocal(String local) {
		locais.add(local);
	}
	
	public void cadastrarHorario(String horario, String dia) {
		horarios.add(new Horario(horario, dia));
	}
	
	public String listaHorarios() {
		String listaHorarios = "";
		for (Horario i : horarios)
			listaHorarios += i.toString() + "\n";
		return listaHorarios;
	}
	
	public String listaLocais() {
		String listaLocais = "";
		for (String i : locais)
			listaLocais += i + "\n";
		return listaLocais;
	}
	
	public HashSet<Horario> getHorarios(){
		return horarios;
	}
	
	public HashSet<String> getLocais(){
		return locais;
	}
}