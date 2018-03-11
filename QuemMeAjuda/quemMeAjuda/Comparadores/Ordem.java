package quemMeAjuda.Comparadores;

public enum Ordem {

	NOME("NOME"), MATRICULA("MATRICULA"), EMAIL("EMAIL");
	
	private String descricao;
	
	private Ordem(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}