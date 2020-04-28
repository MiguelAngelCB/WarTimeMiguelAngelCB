package pruebasui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Juego;
import modelo.Coordenada;
import vista.TableroUI;
import vista.Conversores.Generador;
import vista.info.TableroUIInfo;

public class JuegoPrueba extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	private TableroUIInfo tableroUIInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoPrueba frame = new JuegoPrueba();
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
	public JuegoPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Juego juego = new Juego(11, 6);
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				JPanel panel = (JPanel) e.getSource();
				Coordenada coordenadaPanel = Generador.obtenCoordenada(panel.getName());
				if (juego.getTablero().comprobarPosicionLibre(coordenadaPanel)) {
					juego.meterSoldadoTablero(coordenadaPanel);
				}
				tableroUI.actualizarTablero(tableroUIInfo);
			}
		};
		tableroUIInfo = new TableroUIInfo(juego.getTablero());
		tableroUI = new TableroUI(6, 12, mouseAdapter, tableroUIInfo);
		contentPane.add(tableroUI, BorderLayout.CENTER);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

}
