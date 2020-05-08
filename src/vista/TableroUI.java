package vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Castillo;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;
import vista.info.FichaBatallonInfo;
import vista.info.FichaCastilloInfo;
import vista.info.FichaInfo;
import vista.info.FichaTrincheraInfo;
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
		FichaInfo[][] fichasInfo = tableroUIInfo.getFichasInfo();
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

	public JPanel getFicha(FichaInfo fichaInfo) {
		if (fichaInfo instanceof FichaBatallonInfo) {
			FichaBatallonInfo fichaBatallonInfo = (FichaBatallonInfo) fichaInfo;
			return new FichaBatallon(fichaBatallonInfo);
		} else if (fichaInfo instanceof FichaCastilloInfo) {
			FichaCastilloInfo fichaCastilloInfo = (FichaCastilloInfo) fichaInfo;
			return new FichaCastillo(fichaCastilloInfo);
		} else if (fichaInfo instanceof FichaTrincheraInfo) {
			FichaTrincheraInfo fichaTrincheraInfo = (FichaTrincheraInfo) fichaInfo;
			return new FichaTrinchera(fichaTrincheraInfo);
		}
		return new FichaBlanca();
	}
}
