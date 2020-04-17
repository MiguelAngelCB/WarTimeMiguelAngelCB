package ensayos;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Batallon;
import vista.Conversores.Generador;
import vista.info.EspecialidadSoldadoInfo;
import vista.info.EspecificacionSoldadosInfo;
import vista.info.MercadoSoldadoInfo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MercadoSoldadosEnsayo extends JPanel {
	private JLabel lblBatallonId;
	private JLabel lblMaxSoldados;
	private ArrayList<EspecialidadSoldadosEnsayo> especialidades;
	private JLabel lblTipoSoldado;
	private JLabel lblTotal;
	private FocusAdapter miFocusAdapter=new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
				lblTotal.setText(String.valueOf(sumaSoldados()));
			}
		};
	
	/**
	 * Create the panel.
	 */
	public MercadoSoldadosEnsayo(MercadoSoldadoInfo info) {
		setLayout(null);
		especialidades = Generador.getEspecialidadesEnsayo(info.getTipo(),miFocusAdapter);

		JLabel lblBatallonNumero = new JLabel("Batallon numero ");
		int height2 = 16;
		lblBatallonNumero.setBounds(62, 51, 165, height2);
		add(lblBatallonNumero);

		lblBatallonId = new JLabel(String.valueOf(info.getId()));
		lblBatallonId.setBounds(256, 51, 56, height2);
		add(lblBatallonId);

		JLabel lblMax = new JLabel("max.");
		lblMax.setBounds(395, 51, 56, height2);
		add(lblMax);

		lblMaxSoldados = new JLabel(String.valueOf(info.getMaximoSoldados()));
		lblMaxSoldados.setBounds(482, 51, 56, height2);
		add(lblMaxSoldados);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(62, 135, 56, height2);
		add(lblTipo);

		lblTipoSoldado = new JLabel(String.valueOf(info.getTipo()));
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

		lblTotal = new JLabel(String.valueOf(sumaSoldados()));
		lblTotal.setBounds(245, 390, 56, height2);
		add(lblTotal);

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

	public LinkedList<EspecificacionSoldadosInfo> getListaEjercito() {
		LinkedList<EspecificacionSoldadosInfo> response=new LinkedList<EspecificacionSoldadosInfo>();
		for (EspecialidadSoldadosEnsayo especialidad : especialidades) {
			response.add(new EspecificacionSoldadosInfo(especialidad.getLblEspecialidad().toString(),
			Integer.valueOf(especialidad.getTxtCantidad().getText().toString())));
		}
		return response;
	}
}
