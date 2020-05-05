package modelo;

public class Castillo implements Casilla {
	private Ejercito ejercito;

	public Castillo(Ejercito ejercito) {
		this.ejercito = ejercito;
	}

	public Ejercito getEjercito() {
		return ejercito;
	}

}
