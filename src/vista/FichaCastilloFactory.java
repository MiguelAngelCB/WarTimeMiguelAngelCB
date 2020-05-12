package vista;

import javax.swing.JPanel;

import vista.info.FichaCastilloInfo;
import vista.info.FichaInfo;
import vista.info.Info;

public class FichaCastilloFactory implements FichaInfo{

	@Override
	public JPanel getPanel(Info Info) {
		return new FichaCastillo((FichaCastilloInfo)Info);
	}

}
