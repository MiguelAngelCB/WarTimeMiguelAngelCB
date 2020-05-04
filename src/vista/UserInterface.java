package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Tablero;
import vista.info.TableroUIInfo;

public class UserInterface extends JFrame {

	protected JPanel contentPane;
	protected TableroUI tableroUI;
	protected BordeArmada bordeArmada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Tablero tablero = new Tablero(6, 12);
		TableroUIInfo tableroUIInfo = new TableroUIInfo(tablero);
		tableroUI = new TableroUI(6, 12);
		bordeArmada = new BordeArmada();
		contentPane.add(tableroUI, BorderLayout.CENTER);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane.add(bordeArmada, BorderLayout.WEST);
	}

}
