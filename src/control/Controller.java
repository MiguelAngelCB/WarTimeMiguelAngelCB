package control;

import java.util.List;

import modelo.Coordenada;
import vista.info.EspecificacionSoldadosInfo;

public class Controller {
	private LocalizadorController localizadorController;
	private PobladorController pobladorController;

	public Controller(Juego juego) {
		super();
		this.localizadorController = new LocalizadorController(juego);
	}

	public boolean localizarBatallones(Coordenada coordenada) {
		return localizadorController.localizar(coordenada);
	}

	public void poblarBatallones(List<EspecificacionSoldadosInfo> especificacion) {
		pobladorController = new PobladorController(getJuego().getBatallonActual());
		pobladorController.poblarBatallon(especificacion);
	}

	public Juego getJuego() {
		return localizadorController.getJuego();
	}

}
