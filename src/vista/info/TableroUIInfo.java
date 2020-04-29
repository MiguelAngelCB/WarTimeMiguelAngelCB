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
		FichaInfo[][] fichasFichaInfos=new FichaInfo[tablero.getAncho()][tablero.getAlto()];
		for (int i = 0; i < fichasFichaInfos.length; i++) {
			for (int j = 0; j < fichasFichaInfos[i].length; j++) {
				fichasFichaInfos[i][j]=Generador.getFichaInfo(tablero, new Coordenada(i, j));
			}
		}
		return fichasFichaInfos;
	}
}
