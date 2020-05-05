package vista;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vista.Conversores.Generador;
import vista.info.EspecificacionSoldadosInfo;
import vista.info.MercadoSoldadoInfo;
import java.awt.Font;

public class MercadoSoldados extends JPanel {

	private JLabel lblBatallonId;
	private JLabel lblMaxSoldados;
	private ArrayList<EspecialidadSoldado> especialidades;
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
	public MercadoSoldados(MercadoSoldadoInfo info) {
		setLayout(null);
		especialidades = Generador.getEspecialidades(info.getTipo(),miFocusAdapter);

		JLabel lblBatallonNumero = new JLabel("Batallon numero ");
		lblBatallonNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		int height2 = 16;
		lblBatallonNumero.setBounds(62, 51, 165, height2);
		add(lblBatallonNumero);

		lblBatallonId = new JLabel(String.valueOf(info.getId()));
		lblBatallonId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBatallonId.setBounds(256, 51, 56, height2);
		add(lblBatallonId);

		JLabel lblMax = new JLabel("max.");
		lblMax.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMax.setBounds(395, 51, 56, height2);
		add(lblMax);

		lblMaxSoldados = new JLabel(String.valueOf(info.getMaximoSoldados()));
		lblMaxSoldados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaxSoldados.setBounds(482, 51, 56, height2);
		add(lblMaxSoldados);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipo.setBounds(62, 135, 56, height2);
		add(lblTipo);

		lblTipoSoldado = new JLabel(String.valueOf(info.getTipo()));
		lblTipoSoldado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoSoldado.setBounds(171, 135, 56, height2);
		add(lblTipoSoldado);
		int y = 223;
		for (EspecialidadSoldado especialidadSoldados : especialidades) {
			especialidadSoldados.setBounds(75, y, 556, height2);
			add(especialidadSoldados);
			y += height2 + 5;
		}
		JLabel lblTotalf = new JLabel("Total");
		lblTotalf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalf.setBounds(62, 346, 56, height2);
		add(lblTotalf);

		lblTotal = new JLabel(String.valueOf(sumaSoldados()));
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotal.setBounds(199, 346, 56, height2);
		add(lblTotal);

	}

	private int sumaSoldados() {
		int total = 0;
		for (EspecialidadSoldado especialidadSoldadosEnsayo : especialidades) {
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

	public LinkedList<EspecificacionSoldadosInfo> getEspecificaciones() {
		LinkedList<EspecificacionSoldadosInfo> response=new LinkedList<EspecificacionSoldadosInfo>();
		for (EspecialidadSoldado especialidad : especialidades) {
			response.add(new EspecificacionSoldadosInfo(especialidad.getLblEspecialidad().toString(),
			Integer.valueOf(especialidad.getTxtCantidad().getText().toString())));
		}
		return response;
	}

	public boolean compruebaMax() {
		return sumaSoldados()==Integer.valueOf(lblMaxSoldados.getText());
	}
}
