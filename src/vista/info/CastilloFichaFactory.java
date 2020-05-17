package vista.info;

import javax.swing.JPanel;

import modelo.Castillo;
import modelo.Ejercito;
import vista.FichaCastillo;

public class CastilloFichaFactory implements FichaFactory {
	Ejercito ejercito;
	

	public CastilloFichaFactory(Ejercito ejercito) {
		super();
		this.ejercito=ejercito;
	}

	@Override
	public JPanel getPanel() {
		return new FichaCastillo(ejercito.getId());
	}

}
