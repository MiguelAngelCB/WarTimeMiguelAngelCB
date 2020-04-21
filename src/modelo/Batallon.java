package modelo;

import java.awt.Color;
import java.util.LinkedList;

public class Batallon implements Casilla{
	private int id;
	private final int maximoSoldados = 10;
	private Tipo tipo;
	private LinkedList<Soldado> soldados = new LinkedList<Soldado>();
	private Color colorBatallonColor;

	public Batallon(int id, Tipo tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	
	public Batallon(int id, Tipo tipo, LinkedList<Soldado> soldados, Color colorBatallonColor) {
		this(id,tipo);
		this.colorBatallonColor = colorBatallonColor;
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
		assert soldado.getEspecialidad().getTipo().equals(tipo):"epecialidad no compatible";
		return soldados.add(soldado);
		//programacion defensiva
//		boolean response = false;
//		if (soldado.getEspecialidad().getTipo().equals(tipo)) {
//			response = soldados.add(soldado);
//		}
//		return response;
	}

}
