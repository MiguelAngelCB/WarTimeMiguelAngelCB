package vista;

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

import vista.info.EspecificacionSoldadosInfo;
import vista.info.MercadoSoldadoInfo;

public class MercadoSoldadoDialog extends JDialog {

	private  JPanel contentPanel =new JPanel();
	private MercadoSoldados mercadoSoldados;
	private ArrayList<EspecialidadSoldado> especialidades;
	private JButton btnOk;
	
	
	public MercadoSoldadoDialog(MercadoSoldadoInfo info) {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100,750, 500);
		mercadoSoldados = new MercadoSoldados(info);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mercadoSoldados, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// a partir de este momento neceistamos acceder a la informacion
				// del modelo, es decir, tablero, juego, etc. 
				btnOk = new JButton("OK");
				buttonPane.add(btnOk);
				
			}
			
		}
	}

	public LinkedList<EspecificacionSoldadosInfo> getListaEspecificacion() {
		return mercadoSoldados.getEspecificaciones();
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public boolean compruebaMax() {
		return mercadoSoldados.compruebaMax();
	}

	

}
