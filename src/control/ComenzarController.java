package control;

import java.util.List;

import modelo.Coordenada;
import modelo.Soldado;
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
	
	public ComenzarController(Juego juego) {
		super();
		this.juego = juego;
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
	
}
