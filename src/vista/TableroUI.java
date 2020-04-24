package vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista.info.TableroUIInfo;

public class TableroUI extends JPanel {

	// Cada una de las casillas representadas en el tablero
	private JPanel[][] fichas;
	private MouseAdapter mouseAdapter;

	/**
	 * Create the panel.
	 */
	public TableroUI(int ancho, int alto, MouseAdapter mouseAdapter,TableroUIInfo tableroUIInfo) {
		super();
		this.mouseAdapter = mouseAdapter;
		fichas = new JPanel[ancho][alto];
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(ancho, alto, 0, 0));
		actualizarTablero(tableroUIInfo);
	}

	public void actualizarTablero(TableroUIInfo tableroUIInfo) {
		removeAll();
		tableroUIInfo.getFichas(fichas);
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {
				JPanel casilla = fichas[i][j];
				casilla.addMouseListener(mouseAdapter);
				add(casilla);
			}
		}
		revalidate();
	}
}
