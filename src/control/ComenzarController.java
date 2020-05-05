package control;

import java.util.List;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Soldado;
import modelo.Tablero;
import vista.info.EspecificacionSoldadosInfo;

public class ComenzarController {
	private Juego juego;
	// Desde el mismo momento en que toco el modelo tengo que hacer pruebas
	public void poblarBatallon(List<EspecificacionSoldadosInfo> especificacion) {
		assert especificacion != null;
		for (EspecificacionSoldadosInfo especificacionSoldadosInfo : especificacion) {
			for (int i = 0; i < especificacionSoldadosInfo.getCantidad(); i++) {
				juego.alistarSoldadoBatallonActual(new Soldado(especificacionSoldadosInfo.getEspecialidad()));
			}
		}

	}
	
	public boolean isLocalizarEstado() {
		return juego.isLocalizarEstado();
	}

	public ComenzarController(int ancho,int alto) {
		super();
		juego = new Juego(ancho, alto);
	}

	public boolean localizar(Coordenada coordenada) {
		return juego.localizarBatallon(coordenada);
	}

	public String getError() {
		return juego.getErrorActual().getMensaje();
	}
	public Juego getJuego() {
		return juego;
	}

	public Ejercito getEjercitoActual() {
		return juego.getEjercitoActual();
	}

	public Batallon getBatallonActual() {
		return juego.getBatallonActual();
	}

	public Tablero getTablero() {
		return juego.getTablero();
	}
	public int getAncho() {
		return juego.getAncho();
	}
	public int getAlto() {
		return juego.getAlto();
	}
}
