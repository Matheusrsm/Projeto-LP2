package quemMeAjuda2.Sistemas;

import java.util.Map;

import quemMeAjuda2.Entidades.Aluno.Aluno;

public class Sistema {
	
	private SistemaAlunos sisAlunos;
	private SistemaTutoria sisTutor;
	public Sistema() {
		sisAlunos = new SistemaAlunos();
		sisTutor = new SistemaTutoria();
	}
	
	
	public void cadastrarAluno(String  nome, String matricula, int codigoCurso, String telefone, String email) throws Exception {
		sisAlunos.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String listarAlunos() {
		return sisAlunos.listarAlunos();
	}
	
	public String recuperaAluno(String matricula) throws Exception {
		return sisAlunos.recuperaAluno(matricula);		
	}
	
	public String getInfoAluno(String matricula, String atributo) throws Exception {
		return sisAlunos.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws Exception {
		sisAlunos.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) throws Exception {
		return sisAlunos.recuperaTutor(matricula).toString();
	}
	
	public String listarTutores() {
		return sisAlunos.listarTutores();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) throws Exception {
		sisAlunos.cadastrarHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) throws Exception {
		sisAlunos.cadastrarLocalDeAtendimento(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return sisAlunos.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return sisAlunos.consultaLocal(email, local);
	}
	
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) throws Exception {
		return sisTutor.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaOnline(String matrAluno, String disciplina) throws Exception {
		return sisTutor.pedirAjudaOnline(matrAluno, disciplina);
	}
	
	public String pegarTutor(int idAjuda) throws Exception {
		return sisTutor.pegaTutor(idAjuda);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) throws Exception {
		return sisTutor.getInfoAjuda(idAjuda, atributo);
	}
	
	public void avaliarTutor(int idAjuda, int nota) throws Exception {
		sisTutor.avaliarTutor(idAjuda, nota);
	}
	
	public String pegarNota(String matriculaTutor) {
		return sisAlunos.pegarNota(matriculaTutor);
	}

	public String pegarNivel(String matriculaTutor) {
		return sisAlunos.pegarNivel(matriculaTutor);
	}
	
	public void doar(String matriculaTutor, int totalCentavos) throws Exception {
		sisTutor.doar(matriculaTutor, totalCentavos);
	}
	
	public int totalDinheiroTutor(String emailTutor) throws Exception {
		return sisAlunos.totalDinheiroTutor(emailTutor);
	}
	
	public int totalDinheiroSistema() {
		return sisTutor.getCaixa();
	}


	public Map<String, Aluno> getAlunos() {
		return SistemaAlunos.getAlunos();
	}

}
