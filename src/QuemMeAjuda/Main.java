package QuemMeAjuda;


public class Main {

	public static void main(String[] args) throws Exception {
		QuemMeAjuda qma = new QuemMeAjuda();
		qma.cadastrarAluno("  ", "115260904", 10000, " ", "matthew.met@ccc.ufcg.edu.br");
		System.out.println(qma.recuperaAluno("115260904"));
	}
}
