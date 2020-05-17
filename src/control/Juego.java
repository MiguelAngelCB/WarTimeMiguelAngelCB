package control;

import java.util.ArrayDeque;

import modelo.Ataque;
import modelo.Batallon;
import modelo.Blanca;
import modelo.Casilla;
import modelo.Castillo;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Error;
import modelo.Range;
import modelo.Soldado;
import modelo.Tablero;

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
		Ejercito ejercitoCero = new Ejercito(0);
		tablero.insertar(new Castillo(ejercitoCero), new Coordenada(3, 1));
		ejercitos.offer(ejercitoCero);
		Ejercito ejercitoUno = new Ejercito(1);
		tablero.insertar(new Castillo(ejercitoUno), new Coordenada(3, ancho - 2));
		ejercitos.offer(ejercitoUno);
		primerEjercito = ejercitos.peek();
	}

	public void turnoJugador(Coordenada coordenadaBatallon, Coordenada coordenada2) {
		if (getCasilla(coordenadaBatallon) instanceof Batallon) {
			enfrentarBatallon(coordenadaBatallon, coordenada2);
			moverBatallon(coordenadaBatallon, coordenada2);
		}
	}

	public void enfrentarBatallon(Coordenada coordenadaBatallon, Coordenada coordenadaEnemigo) {
		if (getCasilla(coordenadaEnemigo) instanceof Batallon) {
			Batallon batallonJugador = (Batallon) getCasilla(coordenadaBatallon);
			Batallon batallonEnemigo = (Batallon) getCasilla(coordenadaEnemigo);
			Ataque ataque = new Ataque(batallonJugador, batallonEnemigo);
			ataque.combatir();
		}
	}

	public void moverBatallon(Coordenada coordenadaBatallon, Coordenada coordenadaMover) {
		if (getCasilla(coordenadaMover) == null) {
			if (isMovible(coordenadaBatallon, coordenadaMover)) {
				Batallon batallon = (Batallon) getCasilla(coordenadaBatallon);
				if (tablero.insertar(batallon, coordenadaMover)) {
					tablero.liberar(coordenadaBatallon);
				}
			}
		}
	}

	public Boolean isMovible(Coordenada coordenadaBatallon, Coordenada coordenadaMover) {
		Range movimiento = ((Batallon) getCasilla(coordenadaBatallon)).getTipo().getMovinRange();
		int distanciaFila = coordenadaBatallon.getX() - coordenadaMover.getX();
		int distanciaColumna = coordenadaBatallon.getY() - coordenadaMover.getY();
		distanciaFila = Math.abs(distanciaFila);
		distanciaColumna = Math.abs(distanciaColumna);
		return (isRange(distanciaFila, movimiento)) && (isRange(distanciaColumna, movimiento));
	}

	public Boolean isRange(int distancia, Range movimiento) {
		return (distancia >= movimiento.getMinRange() && distancia <= movimiento.getMaxRange());
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

	public Ejercito getEjercitoActual() {
		return ejercitos.peek();
	}

	public void alistarSoldadoBatallonActual(Soldado soldado) {
		// Demeter
		getEjercitoActual().getBatallonActual().alistarSoldado(soldado);
	}

	public Batallon getBatallonActual() {
		return getEjercitoActual().getBatallonActual();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public Casilla getCasilla(Coordenada coordenada) {
		Casilla casilla = tablero.getCasilla(coordenada);
		if (casilla == null) {
			return new Blanca();
		}
		return casilla;
	}

}
