package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.Coordenada;
import utiles.Utiles;
import vista.UserInterface;
import vista.Conversores.Generador;

public class ParaUI extends UserInterface {
	Controller controller;
	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if (!bordeArmada.getBtnPoblar().isEnabled()) {
				JPanel panel = (JPanel) e.getSource();
				Coordenada coordenada = Utiles.getCoordenada(panel.getName());
				if (controller.localizarBatallones(coordenada)) {
					tableroUI.actualizarTablero(Generador.getTableroUIInfo(controller.getJuego()));
					bordeArmada.getBtnPoblar().setEnabled(true);
				}
			}
		}
	};

	public ParaUI() {
		super();
		controller = new Controller(new Juego(6, 12));
		tableroUI.setMouseAdapter(mouseAdapter);
		Juego juego = new Juego(6, 12);
		tableroUI.actualizarTablero(Generador.getTableroUIInfo(juego));
		bordeArmada.cargarEjercito(Generador.getEjercitoInfo(controller.getJuego().getEjercitoActual()));
		bordeArmada.getBtnPoblar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bordeArmada.getBtnPoblar().setEnabled(false);
			}

		});
	}

}
