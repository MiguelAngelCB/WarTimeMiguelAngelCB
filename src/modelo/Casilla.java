package modelo;

import vista.info.FichaFactory;

public interface Casilla {
	// lo abstracto
	public FichaFactory getFactory(Ejercito ejercito);

}
