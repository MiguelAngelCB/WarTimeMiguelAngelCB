package modelo;

import vista.info.FichaBlancaInfo;
import vista.info.FichaInfo;

public class Blanca implements Casilla {

	@Override
	public FichaInfo getInfo(Ejercito ejercito) {
		return new FichaBlancaInfo();
	}

}
