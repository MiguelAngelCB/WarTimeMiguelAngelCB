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
		boolean insertar = false;
		setIdEjercitoActual(coordenada);
		Ejercito ejercito = getEjercitoActual();
		if (!ejercito.comprobarUltimoBatallon()) {
			Batallon batallonActual = getBatallonActual();
			insertar = tablero.insertar(batallonActual, coordenada);
			if (insertar) {
				ejercito.setSiguienteBatallon();
			}
		}
		return insertar;
	}

	public Batallon getBatallonActual() {
		return getEjercitoActual().getBatallonActual();
	}

	public Ejercito getEjercitoActual() {
		return ejercitos.get(idEjercitoActual);
	}

	public void setIdEjercitoActual(Coordenada coordenada) {
		if (tablero.mitadTablero(coordenada)) {
			this.idEjercitoActual = ejercitos.size() - 1;
		} else {
			this.idEjercitoActual = 0;
		}
	}

}
