package older;

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
import vista.BordeArmada;
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
					ParaUIPruebaTablero frame = new ParaUIPruebaTablero();
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
		
		Tablero tablero=new Tablero(12, 6);
		tablero.insertar(new Batallon(4, Tipo.infanteria), new Coordenada(4, 4));
		TableroUIInfo tableroUIInfo=new TableroUIInfo(tablero);
		tableroUI = new TableroUI(12, 6);
		contentPane.add(tableroUI, BorderLayout.CENTER);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane.add(new BordeArmada(),BorderLayout.WEST);
	}

	public TableroUI getTableroUI() {
		return tableroUI;
	}

}
