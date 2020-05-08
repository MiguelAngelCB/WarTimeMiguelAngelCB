package vista.info;

import control.Juego;
import modelo.Coordenada;
import modelo.Tablero;
import vista.Conversores.Generador;

public class TableroUIInfo {

	private Juego juego;

	
	
	public TableroUIInfo(Juego juego) {
		super();
		this.juego = juego;
	}


	public FichaInfo[][] getFichasInfo(){
		FichaInfo[][] fichasInfo=new FichaInfo[juego.getAlto()][juego.getAncho()];
		for (int i = 0; i < fichasInfo.length; i++) {
			for (int j = 0; j < fichasInfo[i].length; j++) {
				fichasInfo[i][j]=Generador.getFichaInfo(juego, new Coordenada(i, j));
			}
		}
		return fichasInfo;
	}

}
