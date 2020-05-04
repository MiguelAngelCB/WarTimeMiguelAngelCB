package control;

import java.util.ArrayDeque;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Tablero;
import modelo.Error;
import modelo.Soldado;

public class Juego {
	private Tablero tablero;
	private int ancho, alto;
	private ArrayDeque<Ejercito> ejercitos = new ArrayDeque<Ejercito>();
	private boolean localizarEstado = true;
	private Ejercito primerEjercito;
	private Error errorActualError = null;

	public boolean isLocalizarEstado() {
		return localizarEstado;
	}

	public Juego(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		tablero = new Tablero(ancho, alto);
		ejercitos.offer(new Ejercito(0));
		ejercitos.offer(new Ejercito(1));
		primerEjercito = ejercitos.peek();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public boolean localizarBatallon(Coordenada coordenada) {
		boolean insertar = comprobarLocalizacion(coordenada);
		if (!insertar) {
			errorActualError = Error.posicion;
		} else if (localizarEstado) {
			Ejercito ejercito = ejercitos.peek();
			Batallon batallonActual = ejercito.getBatallonActual();
			insertar = tablero.insertar(batallonActual, coordenada);
			if (insertar) {
				if (!ejercito.setSiguienteBatallon()) {
					setSiguienteEjercito();
				}
			} else {
				errorActualError = Error.ocupada;
			}
		}
		return insertar && localizarEstado;
	}

	public Error getErrorActual() {
		Error response = errorActualError;
		errorActualError = Error.noerror;
		return response;
	}

	private boolean comprobarLocalizacion(Coordenada coordenada) {
		return getTablero().isEnSuMitad(getEjercitoActual(), coordenada);
	}

	private void setSiguienteEjercito() {
		ejercitos.offer(ejercitos.poll());
		if (ejercitos.peek().equals(primerEjercito)) {
			localizarEstado = false;
		}
	}

	private Ejercito getEjercitoActual() {
		return ejercitos.peek();
	}

	public void alistarSoldadoBatallonActual(Soldado soldado) {
		// Demeter
		getEjercitoActual().getBatallonActual().alistarSoldado(soldado);
	}
}
