package vista.info;

import control.Juego;
import modelo.Casilla;
import modelo.Coordenada;

public class TableroUIInfo {

	private Juego juego;

	
	
	public TableroUIInfo(Juego juego) {
		super();
		this.juego = juego;
	}


	public FichaFactory[][] getFichasInfo(){
		FichaFactory[][] fichasInfo=new FichaFactory[juego.getAlto()][juego.getAncho()];
		for (int i = 0; i < fichasInfo.length; i++) {
			for (int j = 0; j < fichasInfo[i].length; j++) {
				fichasInfo[i][j]=getFichaInfo(juego, new Coordenada(i, j));
			}
		}
		return fichasInfo;
	}
	public FichaFactory getFichaInfo(Juego juego, Coordenada coordenada) {
		Casilla casilla = juego.getCasilla(coordenada);
		return casilla.getFactory(juego.getEjercitoActual());
	}

}
