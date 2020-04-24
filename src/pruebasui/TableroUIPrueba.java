package pruebasui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Tablero;
import modelo.Tipo;
import vista.TableroUI;
import vista.info.TableroUIInfo;

public class TableroUIPrueba extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroUIPrueba frame = new TableroUIPrueba();
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
	public TableroUIPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				JPanel panel = (JPanel) e.getSource();
				panel.setBackground(Color.YELLOW);
				// Por esta razon el mouseAdapter tiene que ser una propiedad del tableroui
//				tableroUI.actualizarTablero(mouseAdapter);
//				tableroUI.actualizarTablero();
			}
		};
		Tablero tablero=new Tablero(6, 12);
		tablero.insertar(new Batallon(4, Tipo.infanteria), new Coordenada(4, 4));
		TableroUIInfo tableroUIInfo=new TableroUIInfo(tablero);
		tableroUI = new TableroUI(6, 12, mouseAdapter,tableroUIInfo);
		contentPane.add(tableroUI, BorderLayout.CENTER);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

}
