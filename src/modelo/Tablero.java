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
		casillas = new Matriz<Coordenada, Casilla>(ancho, alto);
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas.getElement(coordenada);
	}

	public void insertar(Batallon batallon,Coordenada coordenada) {
		casillas.insertElement(coordenada, batallon);
	}
	public void insertar(Casilla casilla,Coordenada coordenada) {
		casillas.insertElement(coordenada, casilla);
	}
}
