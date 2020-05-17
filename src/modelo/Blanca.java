package modelo;

import vista.info.BlancaFichaFactory;
import vista.info.FichaFactory;

public class Blanca implements Casilla {
	
	@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		return new BlancaFichaFactory();
	}

}
