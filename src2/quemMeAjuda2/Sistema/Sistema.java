package quemMeAjuda2.Sistema;

public interface Sistema {
	public void cadastrarAluno(String  nome, String matricula, int codigoCurso, String telefone, String email) throws Exception;
	public String listarAlunos();
	public String recuperaAluno(String matricula) throws Exception;
	public String getInfoAluno(String matricula, String atributo) throws Exception;
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws Exception;
	public String recuperaTutor(String matricula) throws Exception;
	public String listarTutores();
	public void cadastrarHorario(String email, String horario, String dia) throws Exception;
	public void cadastrarLocalDeAtendimento(String email, String local) throws Exception;
	public boolean consultaHorario(String email, String horario, String dia);	
	public boolean consultaLocal(String email, String local);
}
