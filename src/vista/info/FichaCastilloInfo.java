package vista.info;

public class FichaCastilloInfo implements FichaInfo{
	private int idEjercito;

	public FichaCastilloInfo(int idEjercito) {
		super();
		this.idEjercito = idEjercito;
	}

	public int getIdEjercito() {
		return idEjercito;
	}

}
