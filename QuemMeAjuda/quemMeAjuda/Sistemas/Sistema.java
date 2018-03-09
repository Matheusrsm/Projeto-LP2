package quemMeAjuda.Sistemas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import quemMeAjuda.Entidades.Aluno.Aluno;

public class Sistema {
	
	private ControllerAlunos controladorAlunos;
	private ControllerTutoria controladorTutoria;
	
	public Sistema() {
		controladorAlunos = new ControllerAlunos();
		controladorTutoria = new ControllerTutoria();
	}
	
	public void cadastrarAluno(String  nome, String matricula, int codigoCurso, String telefone, String email) throws Exception {
		controladorAlunos.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String listarAlunos() {
		return controladorAlunos.listarAlunos();
	}
	
	public String recuperaAluno(String matricula) throws Exception {
		return controladorAlunos.recuperaAluno(matricula);		
	}
	
	public String getInfoAluno(String matricula, String atributo) throws Exception {
		return controladorAlunos.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws Exception {
		controladorAlunos.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) throws Exception {
		return controladorAlunos.recuperaTutor(matricula).toString();
	}
	
	public String listarTutores() {
		return controladorAlunos.listarTutores();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) throws Exception {
		controladorAlunos.cadastrarHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) throws Exception {
		controladorAlunos.cadastrarLocalDeAtendimento(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return controladorAlunos.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return controladorAlunos.consultaLocal(email, local);
	}
	
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) throws Exception {
		return controladorTutoria.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaOnline(String matrAluno, String disciplina) throws Exception {
		return controladorTutoria.pedirAjudaOnline(matrAluno, disciplina);
	}
	
	public String pegarTutor(int idAjuda) throws Exception {
		return controladorTutoria.pegaTutor(idAjuda);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) throws Exception {
		return controladorTutoria.getInfoAjuda(idAjuda, atributo);
	}
	
	public void avaliarTutor(int idAjuda, int nota) throws Exception {
		controladorTutoria.avaliarTutor(idAjuda, nota);
	}
	
	public String pegarNota(String matriculaTutor) {
		return controladorAlunos.pegarNota(matriculaTutor);
	}

	public String pegarNivel(String matriculaTutor) {
		return controladorAlunos.pegarNivel(matriculaTutor);
	}
	
	public void doar(String matriculaTutor, int totalCentavos) throws Exception {
		controladorTutoria.doar(matriculaTutor, totalCentavos);
	}
	
	public int totalDinheiroTutor(String emailTutor) throws Exception {
		return controladorAlunos.totalDinheiroTutor(emailTutor);
	}
	
	public int totalDinheiroSistema() {
		return controladorTutoria.getCaixa();
	}
	
	public void configurarOrdem(String atributo) {
		controladorAlunos.configurarOrdem(atributo);
	}
	
	////// MATHEUS/LUKAS, ALTEREM O PARAMETRO PARA FICAR NO DIRETORIO DO PROJETO NO PC DE VCS SE NAO DÁ NULLPOINTED////////
	public void salvar() throws Exception {
		char s = File.separatorChar;
		try {
		    File arquivoAlunos = new File(s + "home" + s + "wesley" + s + "wesley-workspace" + s + "Quem Me Ajuda" + s + "Dados" + s + "alunos.txt");
		    File arquivoTutores = new File(s + "home" + s + "wesley" + s + "wesley-workspace" + s + "Quem Me Ajuda" + s + "Dados" + s + "tutores.txt");
		    FileOutputStream fosAlunos = new FileOutputStream(arquivoAlunos);
		    FileOutputStream fosTutores = new FileOutputStream(arquivoTutores);
		    ObjectOutputStream writerAlunos = new ObjectOutputStream(fosAlunos);
		    ObjectOutputStream writerTutores = new ObjectOutputStream(fosTutores);
		    writerAlunos.writeObject(this.controladorAlunos);
		    writerTutores.writeObject(this.controladorTutoria);
		    writerAlunos.flush();
		    writerAlunos.close();
		    writerTutores.flush();
		    writerTutores.close();
		    fosAlunos.flush();
		    fosTutores.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	////// MATHEUS/LUKAS, ALTEREM O PARAMETRO PARA FICAR NO DIRETORIO DO PROJETO NO PC DE VCS SE NAO DÁ NULLPOINTED////////
	//////// CARREGAR COM ALGUM PROBLEMA ACREDITO EU /////
	public void carregar() {
		char s = File.separatorChar;
		File pasta = new File(s + "home" + s + "wesley" + s + "wesley-workspace" + s + "Quem Me Ajuda" + s + "Dados");
		File[] arquivos = pasta.listFiles();
		FileInputStream fis = null;  
		ObjectInputStream reader = null;
		try {
			for(File arquivo : arquivos){
				if (arquivo.getName().equals("alunos.txt")){
					fis = new FileInputStream(arquivo);
					reader = new ObjectInputStream(fis);
					this.controladorAlunos = (ControllerAlunos) reader.readObject();
				}
				else if (arquivo.getName().equals("tutores.txt")) {
					fis = new FileInputStream(arquivo);
					reader = new ObjectInputStream(fis);
					this.controladorTutoria = (ControllerTutoria) reader.readObject();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public Map<String, Aluno> getAlunos() {
		return ControllerAlunos.getAlunos();
	}
}