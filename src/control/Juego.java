package control;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Tablero;
import vista.Conversores.Generador;

public class Juego {
	private Tablero tablero;
	private Ejercito ejercitoJugador1;
	private Ejercito ejercitoJugador2;

	public Juego(int ancho, int alto) {
		super();
		tablero = new Tablero(ancho, alto);
		ejercitoJugador1 = new Ejercito(1);
		ejercitoJugador2 = new Ejercito(2);
	}

	public void meterSoldadoTablero(Coordenada coordenada) {
		Batallon batallon;
		if (!Generador.mitadTablero(tablero, coordenada)) {
			conseguirUltimoBatallon(ejercitoJugador1, coordenada);
		} else {
			conseguirUltimoBatallon(ejercitoJugador2, coordenada);
		}
	}

	public void conseguirUltimoBatallon(Ejercito ejercito, Coordenada coordenada) {
		if (!ejercito.comprobarUltimoBatallon()) {
			Batallon batallon = ejercito.getBatallonActual();
			tablero.insertar(batallon, coordenada);
			ejercito.sumarIdBatallonActual();
		}
	}

	public Tablero getTablero() {
		return tablero;
	}

}
