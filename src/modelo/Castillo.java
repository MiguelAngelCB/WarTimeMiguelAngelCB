package modelo;

import vista.info.CastilloFichaFactory;
import vista.info.FichaFactory;

public class Castillo implements Casilla {
	private Ejercito ejercito;

	public Castillo(Ejercito ejercito) {
		this.ejercito = ejercito;
	}

	public Ejercito getEjercito() {
		return ejercito;
	}

	@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		return new CastilloFichaFactory(ejercito);
	}

}
