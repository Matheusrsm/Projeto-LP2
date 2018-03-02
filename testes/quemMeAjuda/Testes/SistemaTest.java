package quemMeAjuda.Testes;
import static org.junit.Assert.*;

import org.junit.Test;

import quemMeAjuda.Auxiliares.DadoInvalidoException;
import quemMeAjuda.Auxiliares.DadoNuloException;
import quemMeAjuda.Auxiliares.Sistema;
import quemMeAjuda.Entidades.Tutor;

/**
 * Classe de teste da Classe Sistema
 * 
 * @author wesleyham
 *
 */
public class SistemaTest {
	
	private Sistema sis = new Sistema();
	
	@Test
	public void testCadastrarAlunoSemTelefone() throws Exception {
		sis.cadastrarAluno("Wesley", "123456789", 100, "", "wesley@gmail.com");
		assertEquals("123456789 - Wesley - 100 - wesley@gmail.com", sis.getAlunos().get("123456789").toString());
	}
	
	@Test
	public void testCadastrarAlunoComTelefone() throws Exception{
		sis.cadastrarAluno("Pedro", "123123123", 100, "88889999", "pedro@gmail.com");
		assertEquals("123123123 - Pedro - 100 - 88889999 - pedro@gmail.com", sis.getAlunos().get("123123123").toString());
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testCadastrarMatriculaJaCadastrada() throws Exception {
		sis.cadastrarAluno("Wesley", "123456789", 100, "978548855", "wesley@gmail.com");
		sis.cadastrarAluno("Lukas", "123456789", 100, "988554774", "lukas@gmail.com");
	}
	
	@Test(expected = DadoNuloException.class)
	public void testCadastrarAlunoNomeNulo() throws Exception {
		sis.cadastrarAluno(null, "123456789", 100, "99996666", "eu@gmail.com");
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testCadastrarAlunoNomeVazio() throws Exception {
		sis.cadastrarAluno("", "123456789", 100, "55551111", "tu@gmail.com");
	}
	
	@Test(expected = DadoNuloException.class)
	public void testCadastrarEmailNulo() throws Exception {
		sis.cadastrarAluno("Wesley", "123456789", 100, "10001000", null);
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testCadastrarEmailVazio() throws Exception {
		sis.cadastrarAluno("Lukas", "111111000", 100, "9888745214", "");
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testCadastrarEmailSemArroba() throws Exception {
		sis.cadastrarAluno("Matheus", "110555999", 100, "2030105040", "matheus.gmail.com");
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testCadastrarEmailArrobaNoInicio() throws Exception {
		sis.cadastrarAluno("Wesley", "123456789", 100, "33335555", "@wesley@gmail.com");
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testCadastrarEmailArrobaNoFinal() throws Exception {
		sis.cadastrarAluno("Wesley", "123456789", 100, "10108989", "wesley.gmail.com@");
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testCadastrarEmailSoArroba() throws Exception {
		sis.cadastrarAluno("Wesley", "1230101010", 100, "999995623", "@");
	}
	
	@Test
	public void testRecuperaAluno() throws Exception {
		sis.cadastrarAluno("Matheus", "123456789", 100, "10008000", "matheus@gmail.com");
		assertEquals("123456789 - Matheus - 100 - 10008000 - matheus@gmail.com", sis.recuperaAluno("123456789"));
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testRecuperaAlunoNaoCadastrado() throws Exception {
		sis.recuperaAluno("100100100");
	}
	
	@Test
	public void testListarAlunos() throws Exception {
		String lista = "147258369 - Lukas - 100 - 99998888 - lukas@gmail.com, 100101102 - Matheus - 100 - 987654321 - matheus@gmail.com, "
				+ "123456789 - Wesley - 100 - wesley@gmail.com";
		sis.cadastrarAluno("Matheus", "100101102", 100, "987654321", "matheus@gmail.com");
		sis.cadastrarAluno("Lukas", "147258369", 100, "99998888", "lukas@gmail.com");
		sis.cadastrarAluno("Wesley", "123456789", 100, "", "wesley@gmail.com");
		assertEquals(lista, sis.listarAlunos());
	}
	
	@Test
	public void testGetInfoAlunoNome() throws Exception {
		sis.cadastrarAluno("Wesley", "987654321", 100, "33339999", "wesley@gmail.com");
		assertEquals("Wesley", sis.getInfoAluno("987654321", "nome"));
	}
	
	@Test
	public void testGetInfoAlunoCodigoCurso() throws Exception {
		sis.cadastrarAluno("Wesley", "987654321", 100, "33339999", "wesley@gmail.com");
		assertEquals("100", sis.getInfoAluno("987654321", "codigo do curso"));
	}
	
	@Test
	public void testGetInfoAlunoTelefone() throws Exception {
		sis.cadastrarAluno("Wesley", "987654321", 100, "33339999", "wesley@gmail.com");
		assertEquals("33339999", sis.getInfoAluno("987654321", "telefone"));
	}
	
	@Test
	public void testGetInfoAlunoEmail() throws Exception {
		sis.cadastrarAluno("Wesley", "987654321", 100, "33339999", "wesley@gmail.com");
		assertEquals("wesley@gmail.com", sis.getInfoAluno("987654321", "email"));
	}
	
	@Test(expected = DadoInvalidoException.class)
	public void testGetInfoAlunoNaoCadastrado() throws Exception {
		sis.cadastrarAluno("Wesley", "987654321", 100, "33339999", "wesley@gmail.com");
		sis.getInfoAluno("123456789", "email");
	}
	
	@Test
	public void testGetInfoAlunoDefault() throws Exception {
		sis.cadastrarAluno("Wesley", "987654321", 100, "33339999", "wesley@gmail.com");
		assertEquals(null, sis.getInfoAluno("987654321", "idade"));
	}
	
	@Test
	public void testTornarTutor() throws Exception {
		sis.cadastrarAluno("Wesley", "123456789", 100, "33336666", "wesley@gmail.com");
		sis.tornarTutor("123456789", "Calculo 2", 3);
		sis.tornarTutor("123456789", "Vetorial", 4);
		assertEquals("Calculo 2", ((Tutor) sis.getAlunos().get("123456789")).getDisciplinas().get(0));
		assertEquals("Vetorial", ((Tutor) sis.getAlunos().get("123456789")).getDisciplinas().get(1));
	}
	
}
