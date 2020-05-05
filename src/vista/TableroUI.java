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
		FichaBatallonInfo[][] fichasInfo = tableroUIInfo.getFichasInfo();
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

	public JPanel getFicha(FichaBatallonInfo fichaBatallonInfo) {
		if (fichaBatallonInfo == null) {
			return new FichaBlanca();
		}
		return new FichaBatallon(fichaBatallonInfo);
	}

	public JPanel getFicha(FichaCastilloInfo fichasCastilloInfo) {
		switch (key) {
		case null:
			
			break;
		case fichaCastillo instanceof CastilloInfo.class:
			
			break;
		case null:
		case FichaBatallon instanceof BatallonInfo.class:
			
			break;
		}
		if(fichasCastilloInfo==null) {
			return new FichaBlanca();
		}
		return new FichaCastillo(fichasCastilloInfo);
	}
}
