package vista.info;

import javax.swing.JPanel;

import modelo.Coordenada;
import modelo.Tablero;
import vista.FichaBlanca;
import vista.Conversores.Generador;

public class TableroUIInfo {

	private Tablero tablero;

	public TableroUIInfo(Tablero tablero) {
		super();
		this.tablero = tablero;
	}

	public void getFichas(JPanel fichas[][]) {
		// Por que uso un array matriz para este tablero?
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {
				JPanel fichaInfo = Generador.getFicha(tablero, new Coordenada(i, j));
				fichas[i][j] = fichaInfo;
//						fichas[i][j].addMouseListener(mouseAdapter);

			}
		}
	}
}
