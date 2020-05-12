package Observador;

import java.util.Observable;
import java.util.Random;

public class Estado extends Observable {
	public boolean feliz = true;
	
	public void cambiarEstado() {
		int nextInt = new Random().nextInt(2);
		if (nextInt == 0) {
			feliz = true;
		} else {
			feliz = false;
			setChanged();
			notifyObservers(" animo");
		}
	}
	
}
