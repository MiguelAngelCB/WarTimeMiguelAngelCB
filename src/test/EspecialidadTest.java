package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Especialidad;

class EspecialidadTest {

	@Test
	void testGetTipoPorNombre() {
		assertNull(Especialidad.getTipoPorNombre("noexiste"));
		assertEquals(Especialidad.ballesta, Especialidad.getTipoPorNombre("ballesta"));
	}

}
