package modelo;

public class Ataque {
	private Batallon defensor, atacante;

	public Ataque(Batallon defensor, Batallon atacante) {
		super();
		this.defensor = defensor;
		this.atacante = atacante;
	}

	public boolean combatir() {
		// Porque estamos sacando a los soldados que esten por debajo de staminaCritica
		Soldado defensorSoldado;
		Soldado atacanteSoldado;
		while (hayaSoldados()) {
			defensorSoldado = defensor.getSoldado();
			atacanteSoldado = atacante.getSoldado();
			Refriega refriega = new Refriega(defensorSoldado, atacanteSoldado);
			refriega.lucha();
			defensor.tratarSoldado(defensorSoldado);
			atacante.tratarSoldado(atacanteSoldado);
		}
		return atacante.haySoldados();
	}

	private boolean hayaSoldados() {
		return defensor.haySoldados() && atacante.haySoldados();
	}
}