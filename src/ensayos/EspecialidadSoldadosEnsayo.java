package ensayos;

import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.info.EspecialidadSoldadoInfo;

public class EspecialidadSoldadosEnsayo extends JPanel {
	private JLabel lblEspecialidad;
	private JTextField txtCantidad;
	private FocusAdapter focusAdapter;

	public JLabel getLblEspecialidad() {
		return lblEspecialidad;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	/**
	 * Create the panel.
	 */
	public EspecialidadSoldadosEnsayo(EspecialidadSoldadoInfo especialidad,FocusAdapter focusAdapter) {
		this.focusAdapter=focusAdapter;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Especialidad     :");
		add(lblNewLabel);
		
		lblEspecialidad = new JLabel(String.valueOf(especialidad));
		add(lblEspecialidad);
		
		JLabel lblCantidadc = new JLabel("               Cantidad         :");
		add(lblCantidadc);
		
		txtCantidad = new JTextField("0");
		//pasandole el listener del container
		txtCantidad.addFocusListener(this.focusAdapter);
		//cuidado con poner dos listener
		txtCantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCantidad.setText("");
			}
		});
//		txtCantidad.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("donde action listener");
//			}
//		});
		add(txtCantidad);
		txtCantidad.setColumns(10);

	}

}
