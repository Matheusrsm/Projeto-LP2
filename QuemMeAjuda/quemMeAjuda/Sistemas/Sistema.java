package quemMeAjuda.Sistemas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import quemMeAjuda.Entidades.Aluno.Aluno;
import quemMeAjuda.Entidades.PedidoDeAjuda.PedidoDeAjuda;

public class Sistema {
	
	private ControllerAlunos controladorAlunos;
	private ControllerTutoria controladorTutoria;
	
	public Sistema() {
		controladorAlunos = new ControllerAlunos();
		controladorTutoria = new ControllerTutoria();
	}
	
	public Map<String, Aluno> getAlunos() {
		return ControllerAlunos.getAlunos();
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
	
	public void salvar() {
		try {
		    File arquivoAlunosETurores = new File("Quem Me Ajuda - Alunos e Tutores.txt");
		    File arquivoPedidosDeAjuda = new File("Quem Me Ajuda - Pedidos De Ajuda.txt");
		    File arquivoCaixa = new File("Quem Me Ajuda - Caixa.txt");
		    ObjectOutputStream writerAlunosETurores = new ObjectOutputStream(new FileOutputStream(arquivoAlunosETurores));
		    ObjectOutputStream writerPedidosDeAjuda = new ObjectOutputStream(new FileOutputStream(arquivoPedidosDeAjuda));
		    ObjectOutputStream writerCaixa = new ObjectOutputStream(new FileOutputStream(arquivoCaixa));
		    writerAlunosETurores.writeObject(getAlunos());
		    writerAlunosETurores.close();
		    writerPedidosDeAjuda.writeObject(controladorTutoria.getPedidos());
		    writerPedidosDeAjuda.close();
		    writerCaixa.writeObject(controladorTutoria.getCaixa());
		    writerCaixa.close();
		} catch(IOException e) {e.printStackTrace();}
	}
	
	@SuppressWarnings("unchecked")
	public void carregar() {
		ObjectInputStream arquivo = null;
		try {
			arquivo = new ObjectInputStream(new FileInputStream("Quem Me Ajuda - Alunos e Tutores.txt"));
			try {ControllerAlunos.carregaMapaAlunos((Map<String, Aluno>) arquivo.readObject());} 
			catch (ClassNotFoundException e) {e.printStackTrace();}
			arquivo = new ObjectInputStream(new FileInputStream("Quem Me Ajuda - Pedidos De Ajuda.txt"));
			try {controladorTutoria.carregaMapaPedidos((Map<Integer, PedidoDeAjuda>) arquivo.readObject());} 
			catch (ClassNotFoundException e) {e.printStackTrace();}
			arquivo = new ObjectInputStream(new FileInputStream("Quem Me Ajuda - Caixa.txt"));
			try {controladorTutoria.carregaCaixa((int) arquivo.readObject());} 
			catch (ClassNotFoundException e) {e.printStackTrace();}
		} catch(IOException e) {e.printStackTrace();}	 
	}
	
	public void limpar() {
		File arquivo = null;
		try {
			arquivo = new File("Quem Me Ajuda - Alunos e Tutores.txt");
			arquivo.delete();
			arquivo = new File("Quem Me Ajuda - Pedidos De Ajuda.txt");
			arquivo.delete();
			arquivo = new File("Quem Me Ajuda - Caixa.txt");
			arquivo.delete();
		} catch(Exception e) {e.printStackTrace();}
	}
}