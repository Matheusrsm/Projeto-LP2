package testes;

import exceptions.DadoInvalidoException;

import static org.junit.Assert.*;
import org.junit.Test;
import QuemMeAjuda.Aluno;
import QuemMeAjuda.Tutor;
import QuemMeAjuda.Sistema;

public class AlunoTest {
	private Aluno aluno;
	private Tutor tutor;
	private Sistema sis;
	
	
	@Test (expected = DadoInvalidoException.class)
	public void testAlunoComNomeInvalido() throws Exception {
		aluno = new Aluno("", "115260904", 10000, "", "matthew.met@ccc.ufcg.edu.br");
	}
	
	@Test (expected = DadoInvalidoException.class)
	public void testAlunoComEmailInvalido() throws Exception {
		aluno = new Aluno("Matthews Mello", "115260904", 10000, "", "matthew.met@");
	}
	

}
