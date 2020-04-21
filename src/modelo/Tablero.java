package modelo;

public class Tablero {
	private int ancho, alto;
	//Como tambien puede ser un castillo, habrá que remodelar esto
	private Matriz<Coordenada, Batallon> casillas;
	public Tablero(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		casillas=new Matriz<Coordenada, Batallon>(ancho, alto);
		
	}
	
}
