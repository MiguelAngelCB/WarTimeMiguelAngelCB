package Observador;

import java.util.Observable;
import java.util.Observer;

public class Prueba implements Observer {

	public Estado estado;

	public Prueba() {
		super();
		estado = new Estado();
		estado.addObserver(this);
	}

	public static void main(String[] args) {
		Prueba prueba = new Prueba();
		System.out.println("estoy feliz " + prueba.estado.feliz);
		prueba.estado.cambiarEstado();
		if(!prueba.estado.feliz) {
			
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(" venga arriba" + arg);
	}

}
