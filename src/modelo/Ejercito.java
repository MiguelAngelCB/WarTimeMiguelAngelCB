package modelo;

import java.util.LinkedList;

public class Ejercito {
	private int id;
	private static int infanteria = 1;
	private static int caballeria = 1;
	private static int arqueria = 1;
	private int idBatallonActual = 0;
	// Aunque tiene caracteristicas de SET (los batallones no se repiten)
	// me conviene una list porque puedo hacer get(i)
	LinkedList<Batallon> group = new LinkedList<Batallon>();

	public Ejercito(int id) {
		super();
		this.id = id;
		crearEjercito();
	}

	private void crearEjercito() {
		int j = 0;
		for (int i = 0; i < infanteria; i++) {
			group.add(new Batallon(j++, Tipo.infanteria));
		}
		for (int i = 0; i < caballeria; i++) {
			group.add(new Batallon(j++, Tipo.caballeria));

		}
		for (int i = 0; i < arqueria; i++) {
			group.add(new Batallon(j++, Tipo.arqueria));

		}
	}

	public int getId() {
		return id;
	}

	public static int getInfanteria() {
		return infanteria;
	}

	public static int getCaballeria() {
		return caballeria;
	}

	public static int getArqueria() {
		return arqueria;
	}

	public int getIdBatallonActual() {
		return idBatallonActual;
	}

	public Tipo getTipoBatallon() {
		return getBatallonActual().getTipo();
	}

	public void sumarIdBatallonActual() {
		if (this.idBatallonActual < group.size()) {
			this.idBatallonActual++;
		}
	}

	public boolean comprobarUltimoBatallon() {
		return this.idBatallonActual == group.size();
	}

	public Batallon getBatallonActual() {
		return group.get(idBatallonActual);
	}

}
