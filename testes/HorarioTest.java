import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import QuemMeAjuda.Entidades.Horario;

class HorarioTest {
	
	private Horario horarioTeste = new Horario("15h30", "seg");;

	@Test
	void testConstrutor() {
		assertEquals(horarioTeste.getHorario(), "15h30");
		assertEquals(horarioTeste.getDia(), "seg");
	}

}
