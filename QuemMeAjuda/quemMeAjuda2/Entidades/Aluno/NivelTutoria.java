package quemMeAjuda2.Entidades.Aluno;

public enum NivelTutoria {
	
	APRENDIZ("Aprendiz"), TUTOR("Tutor"), TOP("TOP");
	
	private String descricao;
	
	private NivelTutoria(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}