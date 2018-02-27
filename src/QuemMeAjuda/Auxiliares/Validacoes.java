package QuemMeAjuda.Auxiliares;

public class Validacoes {
		
	public static void validaNome(String nome, String msg) throws DadoInvalidoException {
		if(nome == null || nome.trim().isEmpty()) throw new DadoInvalidoException(msg);
	}
	
	/*
	 *  boolean erro = false;
		int a = email.indexOf("@");
		
		if(!email.contains("@")) erro = true;
		if(email.length() == 1) erro = true;
		if (email.substring(0, a).trim().isEmpty()) erro = true;
		if(email == null || email.trim().isEmpty()) erro = true;
		
		if(erro) throw new DadoInvalidoException(msg);
	 */
	public static void validaEmail(String email, String msg) throws DadoInvalidoException {
		int a = 0;
		boolean erro = false;
		if(!email.contains("@")) erro = true;
		for(int i = 0; i < email.length(); i++)
			if(email.charAt(i) == '@') a = i;
		for(int i = 0; i < a; i++ )
			if(email.charAt(i) != ' ') erro = true;
		for(int i = email.length() -1; i > a; i--)
			if(email.charAt(i) != ' ') erro = true;
		if(erro) throw new DadoInvalidoException(msg);
		if(email == null || email.trim().isEmpty()) throw new DadoInvalidoException(msg);
	}
	
	public static void validaProficiencia(int proficiencia, String msg) throws DadoInvalidoException{
		if(proficiencia < 0 || proficiencia > 5) throw new DadoInvalidoException(msg);
	}
	
	public void validaHorario(String horario, String dia, String msg) throws DadoInvalidoException {
		if(horario.trim().isEmpty()) throw new DadoInvalidoException(msg);
		if(dia.trim().isEmpty()) throw new DadoInvalidoException(msg);
	}
}