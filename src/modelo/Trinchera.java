package modelo;

import vista.info.FichaInfo;
import vista.info.FichaTrincheraInfo;

public class Trinchera implements Casilla {

	@Override
	public FichaInfo getInfo(Ejercito ejercito) {
		return new FichaTrincheraInfo();
	}

}
