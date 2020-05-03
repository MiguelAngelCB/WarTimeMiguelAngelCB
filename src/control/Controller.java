package control;

import modelo.Coordenada;

public class Controller {
	LocalizadorController localizadorController;
	PobladorController pobladorController;

	public Controller(Juego juego) {
		super();
		this.localizadorController = new LocalizadorController(juego);
	}

	private void colocarRellenarBatallones(Coordenada coordenada) {
		if (localizadorController.localizar(coordenada)) {
			pobladorController = new PobladorController(localizadorController.getBatallonActual());
		}
	}

}
