package pruebasui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Tipo;
import vista.MercadoSoldadoDialog;
import vista.info.MercadoSoldadoInfo;

public class MercadoSoldadosPrueba extends JFrame {

	private JPanel contentPane;
	MercadoSoldadoDialog mercadoSoldadoPruebaDialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MercadoSoldadosPrueba frame = new MercadoSoldadosPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MercadoSoldadosPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 479);
		
		JButton btnDialogo = new JButton("dialogo");
		btnDialogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Batallon batallon = new Batallon(1, Tipo.infanteria);
				MercadoSoldadoInfo info = new MercadoSoldadoInfo(batallon);
				mercadoSoldadoPruebaDialog=new MercadoSoldadoDialog(info);
				mercadoSoldadoPruebaDialog.setVisible(true);
			}
		});
		getContentPane().add(btnDialogo, BorderLayout.CENTER);
		
	}

}
