package utiles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilesTest {

	@Test
	void testGetAleatorioSesgadoSinSesgo() {
		int min=1,max=6;
		boolean tocadoMin=false,tocadoMax=false;
		for (int i = 0; i < 100; i++) {
			int aleatorioSesgado = Utiles.getAleatorioSesgado(min, max, 0);
			assertTrue(aleatorioSesgado>=1&&aleatorioSesgado<=6);
			if(aleatorioSesgado==min) tocadoMin=true;
			if(aleatorioSesgado==max) tocadoMax=true;
		}
		assertTrue(tocadoMin);
		assertTrue(tocadoMax);
	}

}
