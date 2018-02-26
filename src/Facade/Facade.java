package Facade;

import QuemMeAjuda.Sistema;
import easyaccept.EasyAccept;
import exceptions.DadoInvalidoException;

public class Facade{
	private Sistema sis;
	
	public static void main(String[] args){
		args = new String[] {"Facade.Facade", "acceptance_test/us1_test.txt",
											 "acceptance_test/us2_test.txt",
											 "acceptance_test/us3_test.txt"};
		
		EasyAccept.main(args);
	}
	
	public void cadastrarAluno(String  nome, String matricula, int codigoCurso, String telefone, String email) throws DadoInvalidoException {
		sis.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String listarAlunos() {
		return sis.listarAlunos();
	}
	
	public String recuperaAluno(String matricula) {
		return sis.recuperaAluno(matricula);
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return sis.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws DadoInvalidoException {
		sis.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) {
		return sis.recuperaTutor(matricula).toString();
	}
	
	public String listaTutores() {
		return sis.listarTutores();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) throws DadoInvalidoException {
		sis.cadastrarHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		sis.cadastrarLocalDeAtendimento(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return sis.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return sis.consultaLocal(email, local);
	}
}
