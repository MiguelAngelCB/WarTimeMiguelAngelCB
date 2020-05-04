package modelo;

import vista.info.FichaInfo;

public class Tablero {
	private int ancho, alto;
	// Como tambien puede ser un castillo, habrá que remodelar esto
	private Matriz<Coordenada, Casilla> casillas;

	public Tablero(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		casillas = new Matriz<Coordenada, Casilla>(alto, ancho);
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas.getElement(coordenada);
	}

	public boolean insertar(Casilla casilla, Coordenada coordenada) {
		boolean response = false;
		if (!casillas.contieneElemento(casilla) && !casillas.contieneClave(coordenada)) {
			casillas.insertElement(coordenada, casilla);
			response = true;
		}
		return response;
	}

	public boolean isEnSuMitad(Ejercito ejercito, Coordenada coordenada) {
		int y = coordenada.getY();
		int mitad = ancho / 2;
		int positionRelativa = y - (mitad * ejercito.getId());
		return positionRelativa >= 0 && positionRelativa < mitad + ejercito.getId();
	}
}
