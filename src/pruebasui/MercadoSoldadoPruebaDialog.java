package pruebasui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ensayos.MercadoSoldadosEnsayo;
import vista.info.EspecificacionSoldadosInfo;
import vista.info.MercadoSoldadoInfo;

public class MercadoSoldadoPruebaDialog extends JDialog {

	private  JPanel contentPanel =new JPanel();
	private MercadoSoldadosEnsayo mercadoSoldados;
	LinkedList<EspecificacionSoldadosInfo> listaEjercito;
	public MercadoSoldadoPruebaDialog(MercadoSoldadoInfo info) {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mercadoSoldados = new MercadoSoldadosEnsayo(info);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mercadoSoldados, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						listaEjercito = mercadoSoldados.getListaEjercito();
						dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
