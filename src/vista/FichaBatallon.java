package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import vista.info.FichaBatallonInfo;

public class FichaBatallon extends JPanel {
	private JTextField txtColorEnemy;
	private JTextField txtColorArmy;
	private JLabel lblExperience;
	private JLabel lblAttack;
	private JLabel lblDefence;
	private JLabel lblHeroe;
	private JLabel lblStamina;
	private JLabel lblUnits;
	private JLabel lblIcono;

	/**
	 * Create the panel.
	 */
	public FichaBatallon(FichaBatallonInfo information) {
		int mediaFont=14,bigFont=20;
		int columns=3;
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		setLayout(new BorderLayout(1, 1));
		
		JPanel bando = new JPanel();
		add(bando, BorderLayout.NORTH);
		bando.setLayout(new BoxLayout(bando, BoxLayout.X_AXIS));
		
		txtColorArmy = new JTextField();
		bando.add(txtColorArmy);
		txtColorArmy.setColumns(columns);
		
		txtColorEnemy = new JTextField();
		txtColorEnemy.setBackground(Color.WHITE);
		bando.add(txtColorEnemy);
		txtColorEnemy.setColumns(columns);
		
		JPanel info = new JPanel();
		add(info, BorderLayout.CENTER);
		info.setLayout(new BorderLayout(0, 0));
		
		JPanel estado = new JPanel();
		estado.setBackground(Color.BLACK);
		info.add(estado, BorderLayout.NORTH);
		estado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("E:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		estado.add(lblNewLabel);
		
		lblExperience = new JLabel("0");
		lblExperience.setBackground(Color.WHITE);
		lblExperience.setForeground(Color.WHITE);
		lblExperience.setFont(new Font("Tahoma", Font.PLAIN, mediaFont));
		estado.add(lblExperience);
		
		JLabel lblNewLabel_2 = new JLabel("A:");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, mediaFont));
		estado.add(lblNewLabel_2);
		
		lblAttack = new JLabel("0");
		lblAttack.setBackground(Color.WHITE);
		lblAttack.setForeground(Color.WHITE);
		lblAttack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		estado.add(lblAttack);
		
		JLabel lblNewLabel_4 = new JLabel("D");
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, mediaFont));
		estado.add(lblNewLabel_4);
		
		lblDefence = new JLabel("0");
		lblDefence.setBackground(Color.WHITE);
		lblDefence.setForeground(Color.WHITE);
		lblDefence.setFont(new Font("Tahoma", Font.PLAIN, mediaFont));
		estado.add(lblDefence);
		
		JPanel heroe = new JPanel();
		estado.add(heroe);
		heroe.setBackground(Color.GREEN);
		heroe.setLayout(new BoxLayout(heroe, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_10 = new JLabel(" ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, bigFont));
		lblNewLabel_10.setBackground(Color.GREEN);
		heroe.add(lblNewLabel_10);
		
		lblHeroe = new JLabel("H");
		lblHeroe.setFont(new Font("Tahoma", Font.PLAIN, mediaFont));
		heroe.add(lblHeroe);
		
		JLabel lblNewLabel_12 = new JLabel(" ");
		heroe.add(lblNewLabel_12);
		JPanel panel = new JPanel();
		info.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel grupo = new JPanel();
		grupo.setBackground(Color.BLACK);
		panel.add(grupo);
		
		JLabel lblNewLabel_6 = new JLabel("S:");
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, mediaFont));
		grupo.add(lblNewLabel_6);
		
		lblStamina = new JLabel("0");
		lblStamina.setForeground(Color.WHITE);
		lblStamina.setFont(new Font("Tahoma", Font.PLAIN,mediaFont));
		grupo.add(lblStamina);
		
		JLabel lblNewLabel_8 = new JLabel("U:");
		lblNewLabel_8.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, mediaFont));
		grupo.add(lblNewLabel_8);
		
		lblUnits = new JLabel("0");
		lblUnits.setForeground(Color.WHITE);
		lblUnits.setFont(new Font("Tahoma", Font.PLAIN, mediaFont));
		grupo.add(lblUnits);
		
		lblIcono = new JLabel(" ");
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setHorizontalTextPosition(SwingConstants.CENTER);
		info.add(lblIcono, BorderLayout.CENTER);
		
		paintValues(information);		 
		
	}

	private void paintValues(FichaBatallonInfo information) {
		ImageIcon sonidoEncendido = new ImageIcon(FichaBatallon.class.getResource(information.getIcon()));
		 ImageIcon sonidoEscalaOn = new ImageIcon(sonidoEncendido.getImage().getScaledInstance(100, 100,
				Image.SCALE_SMOOTH));		 
		 txtColorArmy.setBackground(information.getColorArmy());
		 txtColorEnemy.setBackground(information.getColorEnemy());
		 lblAttack.setText(String.valueOf(information.getAttack()));
		 lblDefence.setText(String.valueOf(information.getDefence()));
		 lblExperience.setText(String.valueOf(information.getExperience()));
		 lblHeroe.setText(Character.toString(information.getHeroe()));
		 lblStamina.setText(String.valueOf(information.getStamina()));
		 lblUnits.setText(String.valueOf(information.getUnits()));
		 lblIcono.setIcon(sonidoEscalaOn);		
	}

}
