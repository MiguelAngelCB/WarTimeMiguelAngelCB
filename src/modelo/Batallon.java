package modelo;

import java.awt.Color;
import java.util.LinkedList;

import vista.info.BatallonFichaFactory;
import vista.info.FichaFactory;

public class Batallon implements Casilla {
	private int id;
	private final int maximoSoldados = 10;
	private Tipo tipo;
	private LinkedList<Soldado> soldados = new LinkedList<Soldado>();
	private Color colorAtacante;

	public Batallon(int id, Tipo tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public Batallon(int id, Tipo tipo, LinkedList<Soldado> soldados, Color colorEjercitoAtacante) {
		this(id, tipo);
		this.colorAtacante = colorEjercitoAtacante;
	}

	public int getId() {
		return id;
	}

	public int getMaximoSoldados() {
		return maximoSoldados;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Integer getCantidadSoldados() {
		return soldados.size();
	}

	public boolean alistarSoldado(Soldado soldado) {
//		//programacion por contrato
		assert soldado.getEspecialidad().getTipo().equals(tipo) : "epecialidad no compatible";
		return soldados.add(soldado);
		// programacion defensiva
//		boolean response = false;
//		if (soldado.getEspecialidad().getTipo().equals(tipo)) {
//			response = soldados.add(soldado);
//		}
//		return response;
	}

	@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		return new BatallonFichaFactory(getId(), getCantidadSoldados(), ejercito);
	}

	public Soldado getSoldado() {
		return soldados.pop();
	}
	// si curamos soldados, los que tengan stamina critica pero mayor que cero
//	public Soldado getSoldado() {
//		Soldado pop = soldados.pop();
//		//usar la cola de soldados como una lista y preguntar (recorrer) si hay algun
//		//elemento no critico
//		while(pop.isCriticaStamina()) {
//			soldados.offer(pop);
//			pop=soldados.pop();
//		}
//		return pop;
//	}

	public void tratarSoldado(Soldado soldado) {
		// TODO Auto-generated method stub
		// nivel de stamina? critico o no
		if (!soldado.isCriticaStamina()) {
			soldados.offer(soldado);
		}
	}

	public boolean haySoldados() {
		return !soldados.isEmpty();
	}
}
