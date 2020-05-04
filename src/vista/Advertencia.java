package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Advertencia extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Advertencia(String mensaje) {
		setBounds(100, 100, 906, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JLabel label = new JLabel(" ");
			contentPanel.add(label);
		}
		{
			JLabel lblAdvertenciavv = new JLabel("Advertencia");
			lblAdvertenciavv.setForeground(Color.RED);
			lblAdvertenciavv.setFont(new Font("Tahoma", Font.BOLD, 26));
			contentPanel.add(lblAdvertenciavv);
		}
		{
			JLabel lblAdvertencia = new JLabel(mensaje);
			lblAdvertencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(lblAdvertencia);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
		setVisible(true);
	}

}
