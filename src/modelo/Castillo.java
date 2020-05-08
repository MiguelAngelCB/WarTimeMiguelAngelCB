package modelo;

import vista.info.FichaCastilloInfo;
import vista.info.FichaInfo;

public class Castillo implements Casilla {
	private Ejercito ejercito;

	public Castillo(Ejercito ejercito) {
		this.ejercito = ejercito;
	}

	public Ejercito getEjercito() {
		return ejercito;
	}

	@Override
	public FichaInfo getInfo(Ejercito ejercito) {
		return new FichaCastilloInfo(ejercito.getId());
	}

}
