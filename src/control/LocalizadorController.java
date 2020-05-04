package control;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Ejercito;

public class LocalizadorController {

	private Juego juego;

	public LocalizadorController(Juego juego) {
		super();
		this.juego = juego;
	}

	public boolean localizar(Coordenada coordenada) {
		return juego.localizarBatallon(coordenada);
	}

	public Batallon getBatallonActual() {
		return juego.getBatallonActual();
	}

	public Ejercito getEjercitoActual() {
		return juego.getEjercitoActual();
	}

	public Juego getJuego() {
		return juego;
	}

}
