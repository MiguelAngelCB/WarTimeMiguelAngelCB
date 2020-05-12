package vista;

import javax.swing.JPanel;

import vista.info.FichaCastilloInfo;
import vista.info.FichaInfo;
import vista.info.Info;

public class FichaCastilloFactory implements FichaInfo{
	private FichaCastilloInfo fichaCastilloInfo;
	
	
	public FichaCastilloFactory(FichaCastilloInfo fichaCastilloInfo) {
		super();
		this.fichaCastilloInfo = fichaCastilloInfo;
	}


	@Override
	public JPanel getPanel() {
		return new FichaCastillo(fichaCastilloInfo);
	}

}
