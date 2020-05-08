package vista.info;

import modelo.Coordenada;
import modelo.Tablero;
import vista.Conversores.Generador;

public class TableroUIInfo {

	private Tablero tablero;

	public TableroUIInfo(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
	public FichaInfo[][] getFichasInfo(){
		FichaInfo[][] fichasInfo=new FichaInfo[tablero.getAlto()][tablero.getAncho()];
		for (int i = 0; i < fichasInfo.length; i++) {
			for (int j = 0; j < fichasInfo[i].length; j++) {
				fichasInfo[i][j]=Generador.getFichaInfo(tablero, new Coordenada(i, j));
			}
		}
		return fichasInfo;
	}

}
