package control;

import modelo.Coordenada;
import modelo.Error;

public class LocalizadorController {

	private Juego juego;

	public LocalizadorController(Juego juego) {
		super();
		this.juego = juego;
	}
	
	public boolean localizar(Coordenada coordenada) {
		return juego.localizarBatallon(coordenada);
	}

	public Juego getJuego() {
		return juego;
	}

	public String getError() {
		return juego.getErrorActual().getMensaje();
	}
	
	
}
