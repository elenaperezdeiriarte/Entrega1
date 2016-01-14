import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;

public class NuevoUsuario extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnEmpezarAJugar;
	
	public final static String EMPEZAR_JUEGO = "EMPEZAR_JUEGO";
	
	public Image imagenFondo;
	public URL fondo;

	
	public NuevoUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 594, 384);
		contentPane = new JPanel()
		{
			public void paintComponent (Graphics g)
			{
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
				
			}
			};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		fondo= this.getClass().getResource("/pacman-1133.jpg");
		imagenFondo = new ImageIcon (fondo).getImage();
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBackground(Color.BLACK);
		lblNombre.setFont(new Font("Consolas", Font.PLAIN, 28));
		lblNombre.setBounds(93, 50, 195, 51);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.PLAIN, 28));
		textField.setBounds(240, 53, 291, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnEmpezarAJugar = new JButton("Empezar a jugar");
		btnEmpezarAJugar.setFont(new Font("Consolas", Font.PLAIN, 28));
		btnEmpezarAJugar.setForeground(Color.WHITE);
		btnEmpezarAJugar.setBackground(Color.BLACK);
		btnEmpezarAJugar.addActionListener(this);
		btnEmpezarAJugar.setBounds(170, 264, 266, 58);
		btnEmpezarAJugar.setActionCommand(EMPEZAR_JUEGO);
		contentPane.add(btnEmpezarAJugar);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		BD.nombreJugador = textField.getText();
		
		switch (e.getActionCommand())
		{
		case EMPEZAR_JUEGO: 
			BD.conexion();
			try {
				BD.anadirUsuario(textField.getText(), 0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			
			Comienzo c = new Comienzo ();
			c.inicioComecocos();
		
			BD.close();

		}
		
	}

}
