package ensayos;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Batallon;
import vista.Conversores.Generador;
import javax.swing.JButton;

public class MercadoSoldadosEnsayo extends JPanel {
	private JLabel lblBatallonId;
	private JLabel lblMaxSoldados;
	private ArrayList<EspecialidadSoldadosEnsayo> especialidades;
	private JLabel lblTipoSoldado;

	/**
	 * Create the panel.
	 */
	public MercadoSoldadosEnsayo(Batallon batallon) {
		setLayout(null);
		especialidades = Generador.getEspecialidadesEnsayo(batallon.getTipo());

		JLabel lblBatallonNumero = new JLabel("Batallon numero ");
		int height2 = 16;
		lblBatallonNumero.setBounds(62, 51, 165, height2);
		add(lblBatallonNumero);

		lblBatallonId = new JLabel(String.valueOf(batallon.getId()));
		lblBatallonId.setBounds(256, 51, 56, height2);
		add(lblBatallonId);

		JLabel lblMax = new JLabel("max.");
		lblMax.setBounds(395, 51, 56, height2);
		add(lblMax);

		lblMaxSoldados = new JLabel(String.valueOf(batallon.getMaximoSoldados()));
		lblMaxSoldados.setBounds(482, 51, 56, height2);
		add(lblMaxSoldados);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(62, 135, 56, height2);
		add(lblTipo);

		lblTipoSoldado = new JLabel(String.valueOf(batallon.getTipo()));
		lblTipoSoldado.setBounds(171, 135, 56, height2);
		add(lblTipoSoldado);
		int y = 223;
		for (EspecialidadSoldadosEnsayo especialidadSoldadosEnsayo : especialidades) {
			especialidadSoldadosEnsayo.setBounds(75, y, 556, height2);
			add(especialidadSoldadosEnsayo);
			y += height2 + 5;
		}
		JLabel lblTotalf = new JLabel("Total");
		lblTotalf.setBounds(62, 390, 56, height2);
		add(lblTotalf);

		JLabel lblTotal = new JLabel(String.valueOf(sumaSoldados()));
		lblTotal.setBounds(245, 390, 56, height2);
		add(lblTotal);

		JButton btnOk = new JButton("ok");
		btnOk.setBounds(497, 416, 97, 25);
		add(btnOk);

	}

	private int sumaSoldados() {
		int total = 0;
		for (EspecialidadSoldadosEnsayo especialidadSoldadosEnsayo : especialidades) {
			String text = especialidadSoldadosEnsayo.getTxtCantidad().getText();
			int cantidad = Integer.valueOf(text);
			total += cantidad;
		}
		return total;
	}

	public JLabel getLblBatallonId() {
		return lblBatallonId;
	}

	public JLabel getLblMaxSoldados() {
		return lblMaxSoldados;
	}

	public JLabel getLblTipoSoldado() {
		return lblTipoSoldado;
	}
}
