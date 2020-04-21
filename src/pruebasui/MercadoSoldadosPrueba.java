package pruebasui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.PobladorController;
import modelo.Batallon;
import modelo.Tipo;
import vista.MercadoSoldadoDialog;
import vista.Conversores.Generador;
import vista.info.MercadoSoldadoInfo;

public class MercadoSoldadosPrueba extends JFrame {

	private JPanel contentPane;
	MercadoSoldadoDialog mercadoSoldadoDialog;
	PobladorController pobladorController;
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
		Batallon batallon = new Batallon(1, Tipo.infanteria);				
		mercadoSoldadoDialog=new MercadoSoldadoDialog(Generador.getMercadoSoldadoInfo(batallon));
		btnDialogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mercadoSoldadoDialog.setVisible(true);
			}
		});
		getContentPane().add(btnDialogo, BorderLayout.CENTER);
		//Esto va a aconectar el ui con el modelo de datos
		pobladorController=new PobladorController(new Batallon(1, Tipo.arqueria));
		getBtnOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
//				MercadoSoldadoDialog dialogo=(MercadoSoldadoDialog)e.getSource();
				if(mercadoSoldadoDialog.compruebaMax()) {
					//aqui es donde hay que conectar con el modelo de datos
					pobladorController.poblarBatallon(mercadoSoldadoDialog.getListaEjercito());
				}
				dispose();
			}
		});
	}

	public JButton getBtnOk() {
		return mercadoSoldadoDialog.getBtnOk();
	}

}
