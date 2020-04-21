package vista;

import java.awt.Component;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import vista.info.EjercitoInfo;

public class BordeArmada extends JPanel {
	private JLabel lblInfanteria;
	private JLabel lblCaballeria;
	private JLabel lblArqueria;
	private JLabel lblCurrentBattalion;
	private JButton btnPoblar;
	private JButton btnLocate;
	private JLabel lblArmy;
	private JLabel lblCurrentBattalionId;

	/**
	 * Create the panel.
	 */
	public BordeArmada() {
		setLayout(new MigLayout("", "[66px][]", "[25px][25px][13px][][][][][][][][][][][][][][][][][][][]"));
	}

	public void cargarEjercito(EjercitoInfo ejercitoInfo) {
		JLabel lblNewLabel = new JLabel("Ejercito");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel, "cell 0 0 2 1,grow");

		lblArmy = new JLabel(String.valueOf(ejercitoInfo.getArmyID()));
		lblArmy.setHorizontalAlignment(SwingConstants.CENTER);
		lblArmy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblArmy, "cell 0 1 2 1,grow");

		JLabel lblNewLabel_9 = new JLabel("Unidades");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel_9, "cell 0 5 2 1,growx,aligny top");

		JLabel lblNewLabel_1 = new JLabel("Infanteria:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel_1, "cell 0 6");

		lblInfanteria = new JLabel(String.valueOf(ejercitoInfo.getInfanteria()));
		lblInfanteria.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInfanteria.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfanteria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblInfanteria, "cell 1 6,growx");

		JLabel lblNewLabel_3 = new JLabel("Caballeria:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel_3, "cell 0 7");

		lblCaballeria = new JLabel(String.valueOf(ejercitoInfo.getCaballeria()));
		lblCaballeria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaballeria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		add(lblCaballeria, "cell 1 7,growx");
		JLabel lblNewLabel_4 = new JLabel("Arqueria:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel_4, "cell 0 8");

		lblArqueria = new JLabel(String.valueOf(ejercitoInfo.getArqueria()));
		lblArqueria.setHorizontalAlignment(SwingConstants.CENTER);
		lblArqueria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblArqueria, "cell 1 8,growx");

		JLabel lblNewLabel_5 = new JLabel("Batallon actual:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel_5, "cell 0 9");

		lblCurrentBattalionId = new JLabel(String.valueOf(ejercitoInfo.getCurrentBattalion()));
		lblCurrentBattalionId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentBattalionId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblCurrentBattalionId, "cell 1 9,growx");

		JLabel lblNewLabel_7 = new JLabel("Tipo Actual");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel_7, "cell 0 12 2 1,growx");

		lblCurrentBattalion = new JLabel(ejercitoInfo.getCurrentSquad().toString());
		lblCurrentBattalion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblCurrentBattalion, "cell 0 13");

		btnPoblar = new JButton("Poblar");

		btnPoblar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(btnPoblar, "cell 0 17 2 1,growx");

		btnLocate = new JButton("Localizar");

		btnLocate.setFont(new Font("Tahoma", Font.PLAIN, 16));

		add(btnLocate, "cell 0 19 2 1,growx");
		btnPoblar.setEnabled(true);
		btnLocate.setEnabled(false);
	}

	public void update(EjercitoInfo armyInfo) {
		lblArmy.setText(String.valueOf(armyInfo.getArmyID()));
		lblArqueria.setText(String.valueOf(armyInfo.getArqueria()));
		lblCaballeria.setText(String.valueOf(armyInfo.getCaballeria()));
		lblCurrentBattalion.setText(armyInfo.getCurrentSquad().toString());
		lblInfanteria.setText(String.valueOf(armyInfo.getInfanteria()));
		lblCurrentBattalionId.setText(String.valueOf(armyInfo.getCurrentBattalion()));
	}

	public void setEnable(boolean enable) {
		for (Component component : Arrays.asList(getComponents())) {
			component.setEnabled(enable);
		}

	}

	public JButton getBtnPoblar() {
		return btnPoblar;
	}

	public JButton getBtnLocate() {
		return btnLocate;
	}

}
