package vista.info;

import javax.swing.JPanel;

import vista.FichaBatallon;

public class FichaBatallonFactory implements FichaInfo{
	private FichaBatallonInfo ficha;

	public FichaBatallonFactory(FichaBatallonInfo ficha) {
		super();
		this.ficha = ficha;
	}

	@Override
	public JPanel getPanel() {
		return new FichaBatallon(ficha);
	}

}
