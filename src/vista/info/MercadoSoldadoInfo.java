package vista.info;

import modelo.Batallon;
import modelo.Tipo;

public class MercadoSoldadoInfo {
	private Tipo tipo;
	private int id;
	private int maximoSoldados;

	public MercadoSoldadoInfo(Batallon batallon) {
		super();
		this.id = batallon.getId();
		this.tipo = batallon.getTipo();
		this.maximoSoldados = batallon.getMaximoSoldados();
	}

	public Tipo getTipo() {
		return tipo;
	}

	public int getId() {
		return id;
	}

	public int getMaximoSoldados() {
		return maximoSoldados;
	}

}
