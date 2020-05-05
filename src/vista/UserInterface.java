package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ComenzarController;
import modelo.Batallon;
import modelo.Coordenada;
import modelo.Tablero;
import modelo.Tipo;
import vista.info.TableroUIInfo;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	private BordeArmada bordeArmada ;

	
	public BordeArmada getBordeArmada() {
		return bordeArmada;
	}
	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		bordeArmada= new BordeArmada();
		contentPane.add(bordeArmada,BorderLayout.WEST);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	public void crearTablero(ComenzarController comenzarController) {
		TableroUIInfo tableroUIInfo=new TableroUIInfo(comenzarController.getTablero());
		tableroUI = new TableroUI(comenzarController.getAncho(), comenzarController.getAlto());
		contentPane.add(tableroUI, BorderLayout.CENTER);
	}
	public TableroUI getTableroUI() {
		return tableroUI;
	}
	public JButton getBtnPoblar() {
		return bordeArmada.getBtnPoblar();
	}
	
}
