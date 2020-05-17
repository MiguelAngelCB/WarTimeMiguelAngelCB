package vista.info;

import javax.swing.JPanel;

import modelo.Ejercito;
import vista.FichaBatallon;

public class BatallonFichaFactory implements FichaFactory {
	int id, units;
	Ejercito ejercito;
	
	


	public BatallonFichaFactory(int id, int units,Ejercito ejercito) {
		super();
		this.id = id;
		this.units = units;
		this.ejercito = ejercito;
	}




	@Override
	public JPanel getPanel() {
		return new FichaBatallon("",ejercito.getId(),id,
				0,0,0,0,units,false,ejercito.getColor());
	}

}
