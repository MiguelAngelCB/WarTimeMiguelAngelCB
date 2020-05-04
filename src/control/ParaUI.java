package control;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.Coordenada;
import utiles.Utiles;
import vista.Advertencia;
import vista.TableroUI;
import vista.UserInterface;
import vista.Conversores.Generador;

public class ParaUI extends UserInterface {
	private ComenzarController comenzarController;
	private Juego juego=new Juego(12, 6);
	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.YELLOW);
			Coordenada coordenada = Utiles.getCoordenada(panel.getName());
			if(!comenzarController.localizar(coordenada)) {
				new Advertencia(comenzarController.getError());
			}
			getTableroUI().actualizarTablero(Generador.getTableroUIInfo(comenzarController.getJuego()));
		}
	};
	public ParaUI() {
		super();
		comenzarController=new ComenzarController(juego);
		getTableroUI().setMouseAdapter(mouseAdapter);
		getTableroUI().actualizarTablero(Generador.getTableroUIInfo(juego));
	}
	
	
}
