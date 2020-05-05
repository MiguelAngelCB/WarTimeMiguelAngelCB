package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import vista.info.FichaCastilloInfo;

import java.awt.Font;

public class FichaCastillo extends JPanel{
	public FichaCastillo(FichaCastilloInfo fichaCastilloInfo) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblCastlloEjercito = new JLabel("Castillo Ejercito");
		lblCastlloEjercito.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCastlloEjercito.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCastlloEjercito, BorderLayout.CENTER);
		
		JLabel lblIdEjercito = new JLabel(String.valueOf(fichaCastilloInfo.getIdEjercito()));
		lblIdEjercito.setFont(new Font("Tahoma", Font.PLAIN, 33));
		add(lblIdEjercito, BorderLayout.EAST);
	}
}
