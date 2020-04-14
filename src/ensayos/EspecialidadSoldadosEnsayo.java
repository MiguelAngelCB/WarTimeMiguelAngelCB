package ensayos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import modelo.Especialidad;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

public class EspecialidadSoldadosEnsayo extends JPanel {
	private JLabel lblEspecialidad;
	private JTextField txtCantidad;

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	/**
	 * Create the panel.
	 */
	public EspecialidadSoldadosEnsayo(Especialidad especialidad) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Especialidad     :");
		add(lblNewLabel);
		
		lblEspecialidad = new JLabel(String.valueOf(especialidad));
		add(lblEspecialidad);
		
		JLabel lblCantidadc = new JLabel("               Cantidad         :");
		add(lblCantidadc);
		
		txtCantidad = new JTextField("0");
		txtCantidad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("donde action listener");
			}
		});
		add(txtCantidad);
		txtCantidad.setColumns(10);

	}

}
