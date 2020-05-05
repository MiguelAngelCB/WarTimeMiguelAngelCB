package older;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Ejercito;
import vista.BordeArmada;
import vista.MercadoSoldadoDialog;
import vista.MercadoSoldados;
import vista.Conversores.Generador;

public class BodeArmadaPrueba extends JFrame {

	private JPanel contentPane;
	private Ejercito ejercito;
	private MercadoSoldadoDialog mercadoSoldado;
	PobladorController pobladorController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BodeArmadaPrueba frame = new BodeArmadaPrueba();
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
	public BodeArmadaPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		BordeArmada comp = new BordeArmada();
		contentPane.add(comp, BorderLayout.WEST);
		ejercito = new Ejercito(0);
		comp.cargarEjercito(Generador.getEjercitoInfo(ejercito));
		//De aqui hay cosas que tendran que cambiar en la version definitiva
		getBtnPoblar(comp).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mercadoSoldado = new MercadoSoldadoDialog(
						Generador.getMercadoSoldadoInfo(ejercito.getBatallonActual()));
				mercadoSoldado.setVisible(true);
				pobladorController=new PobladorController(ejercito.getBatallonActual());
				mercadoSoldado.getBtnOk().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
//						MercadoSoldadoDialog dialogo=(MercadoSoldadoDialog)e.getSource();
						if (mercadoSoldado.compruebaMax()) {
							// aqui es donde hay que conectar con el modelo de datos
							pobladorController.poblarBatallon(mercadoSoldado.getListaEspecificacion());
						}
						dispose();
					}
				});
			}
		});
		
	}

	private JButton getBtnPoblar(BordeArmada comp) {
		return comp.getBtnPoblar();
	}

}
