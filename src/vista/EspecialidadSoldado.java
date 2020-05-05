package vista;

import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.info.EspecialidadSoldadoInfo;
import java.awt.Font;

public class EspecialidadSoldado extends JPanel{
	private JLabel lblEspecialidad;
	private JTextField txtCantidad;
	private FocusAdapter focusAdapter;
	private JLabel label;

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	/**
	 * Create the panel.
	 */
	public EspecialidadSoldado(EspecialidadSoldadoInfo especialidad,FocusAdapter focusAdapter) {
		this.focusAdapter=focusAdapter;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Especialidad :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel);
		
		lblEspecialidad = new JLabel(especialidad.getEspecialidad().toString());
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblEspecialidad);
		
		txtCantidad = new JTextField("5");
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//pasandole el listener del container
		txtCantidad.addFocusListener(this.focusAdapter);
		//cuidado con poner dos listener
		txtCantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCantidad.setText("");
			}
		});
		
		label = new JLabel("   ");
		add(label);
		add(txtCantidad);
		txtCantidad.setColumns(10);

	}

}
