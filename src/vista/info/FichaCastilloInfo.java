package vista.info;

import javax.swing.JPanel;

import vista.FichaCastillo;

public class FichaCastilloInfo implements FichaInfo{
	private int idEjercito;

	public FichaCastilloInfo(int idEjercito) {
		super();
		this.idEjercito = idEjercito;
	}

	public int getIdEjercito() {
		return idEjercito;
	}

	@Override
	public JPanel getPanel() {
		return  new FichaCastillo(this);
	}

}
