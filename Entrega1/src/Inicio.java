import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Inicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnIniciarJuego;
	private JButton btnCrearUsuario;
	private JButton btnVerRanking;
	private JButton btnMostrarRanking;
	
	public final static String INICIAR_JUEGO = "INICIAR_JUEGO";
	public final static String NUEVO_USUARIO = "NUEVO_USUARIO";
	public final static String VER_RANKING = "VER_RANKING";
	
	public Image imagenFondo;
	public URL fondo;
	

	public Inicio() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 424);
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
		
		btnIniciarJuego = new JButton("Iniciar juego");
		btnIniciarJuego.setEnabled(true);
		btnIniciarJuego.setActionCommand(INICIAR_JUEGO);
		btnIniciarJuego.setForeground(Color.WHITE);
		btnIniciarJuego.setFont(new Font("Consolas", Font.PLAIN, 28));
		btnIniciarJuego.setBackground(new Color(0, 0, 0));
		btnIniciarJuego.addActionListener(this);
		btnIniciarJuego.setBounds(10, 52, 259, 54);
		contentPane.add(btnIniciarJuego);
		
		
		btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.setBackground(Color.BLACK);
		btnCrearUsuario.setEnabled(true);
		btnCrearUsuario.setForeground(Color.WHITE);
		btnCrearUsuario.setFont(new Font("Consolas", Font.PLAIN, 28));
		btnCrearUsuario.addActionListener(this);
		btnCrearUsuario.setBounds(318, 52, 259, 54);
		btnCrearUsuario.setActionCommand(NUEVO_USUARIO);
		contentPane.add(btnCrearUsuario);
		
		btnMostrarRanking = new JButton("Mostrar ranking");
		btnMostrarRanking.setFont(new Font("Consolas", Font.PLAIN, 28));
		btnMostrarRanking.setForeground(Color.WHITE);
		btnMostrarRanking.setEnabled(true);
		btnMostrarRanking.setBackground(Color.BLACK);
		btnMostrarRanking.addActionListener(this);
		btnMostrarRanking.setBounds(152, 278, 298, 54);
		btnMostrarRanking.setActionCommand(VER_RANKING);
		contentPane.add(btnMostrarRanking);
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand())
		{
			case INICIAR_JUEGO: IniciarJuego iniciar = new IniciarJuego(); 
			iniciar.setVisible (true); break;
			case NUEVO_USUARIO:NuevoUsuario nuevo = new NuevoUsuario();
			nuevo.setVisible (true); break;
			case VER_RANKING: Ranking ranking = new Ranking();
			ranking.setVisible(true);
			break;	
			
		}
	}
}
