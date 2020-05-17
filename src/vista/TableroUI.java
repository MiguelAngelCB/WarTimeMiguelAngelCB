package vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utiles.Utiles;
import vista.info.FichaFactory;
import vista.info.TableroUIInfo;

public class TableroUI extends JPanel {

	// Cada una de las casillas representadas en el tablero
	private JPanel[][] fichas;
	private MouseAdapter mouseAdapter;

	/**
	 * Create the panel.
	 */
	public TableroUI(int ancho, int alto) {
		super();
		fichas = new JPanel[alto][ancho];
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(alto, ancho, 0, 0));
	}

	public void setMouseAdapter(MouseAdapter mouseAdapter) {
		this.mouseAdapter = mouseAdapter;
	}

	public void actualizarTablero(TableroUIInfo tableroUIInfo) {
		removeAll();
		FichaFactory[][] fichasInfo = tableroUIInfo.getFichasInfo();
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {
				fichas[i][j] = getFicha(fichasInfo[i][j]);
				fichas[i][j].addMouseListener(mouseAdapter);
				fichas[i][j].setName(Utiles.nombrar(i, j));
				add(fichas[i][j]);
			}
		}
		revalidate();
	}

	public JPanel getFicha(FichaFactory fichaInfo) {
		return fichaInfo.getPanel();
	}
}
