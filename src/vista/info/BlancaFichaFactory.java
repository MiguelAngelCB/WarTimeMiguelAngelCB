package vista.info;

import javax.swing.JPanel;

import vista.FichaBlanca;

public class BlancaFichaFactory implements FichaFactory{

	@Override
	public JPanel getPanel() {
		return new FichaBlanca();
	}

}
