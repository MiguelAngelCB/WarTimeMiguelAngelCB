package control;

import java.util.LinkedList;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Tablero;

public class Juego {
	private Tablero tablero;
	private int ancho, alto;
	private LinkedList<Ejercito> ejercitos = new LinkedList<Ejercito>();
	private int idEjercitoActual = 0;
	private boolean localizarEstado = true;

	public boolean isLocalizarEstado() {
		return localizarEstado;
	}

	public Juego(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		tablero = new Tablero(ancho, alto);
		ejercitos.add(new Ejercito(0));
		ejercitos.add(new Ejercito(1));
	}

	public Tablero getTablero() {
		return tablero;
	}

	public boolean localizarBatallon(Coordenada coordenada) {
		boolean insertar = localizarEstado;
		if (insertar) {
			Ejercito ejercito = ejercitos.get(idEjercitoActual);
			Batallon batallonActual = ejercito.getBatallonActual();
			insertar = tablero.insertar(batallonActual, coordenada);
			if (insertar) {
				if (!ejercito.setSiguienteBatallon()) {
					setSiguienteEjercito();
				}
			}
		}
		return insertar;
	}

	private void setSiguienteEjercito() {
		if (++idEjercitoActual == ejercitos.size()) {
			idEjercitoActual = 0;
			localizarEstado = false;
		}
		;
	}

}
