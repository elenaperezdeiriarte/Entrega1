package ud.prog3.pr02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

/** Clase principal de minijuego de coche para Pr�ctica 02 - Prog III
 * Ventana del minijuego.
 * @author Andoni Egu�luz
 * Facultad de Ingenier�a - Universidad de Deusto (2014)
 */
public class VentanaJuego extends JFrame {
	private static final long serialVersionUID = 1L;  // Para serializaci�n
	JPanel pPrincipal;         // Panel del juego (layout nulo)
	MundoJuego miMundo;        // Mundo del juego
	CocheJuego miCoche;        // Coche del juego
	MiRunnable miHilo = null;  // Hilo del bucle principal de juego	
	
	boolean [] botones = new boolean [4];

	/** Constructor de la ventana de juego. Crea y devuelve la ventana inicializada
	 * sin coches dentro
	 */
	public VentanaJuego() {
		// Liberaci�n de la ventana por defecto al cerrar
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// Creaci�n contenedores y componentes
		pPrincipal = new JPanel();
		JPanel pBotonera = new JPanel();
		JButton bAcelerar = new JButton( "Acelera" );
		JButton bFrenar = new JButton( "Frena" );
		JButton bGiraIzq = new JButton( "Gira Izq." );
		JButton bGiraDer = new JButton( "Gira Der." );
		// Formato y layouts
		pPrincipal.setLayout( null );
		pPrincipal.setBackground( Color.white );
		// A�adido de componentes a contenedores
		add( pPrincipal, BorderLayout.CENTER );
		pBotonera.add( bAcelerar );
		pBotonera.add( bFrenar );
		pBotonera.add( bGiraIzq );
		pBotonera.add( bGiraDer );
		add( pBotonera, BorderLayout.SOUTH );
		// Formato de ventana
		setSize( 1000, 750 );
		setResizable( false );
		// Escuchadores de botones
		bAcelerar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				miCoche.acelera( +10, 1 );
				// System.out.println( "Nueva velocidad de coche: " + miCoche.getVelocidad() );
			}
		});
		bFrenar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				miCoche.acelera( -10, 1 );
				// System.out.println( "Nueva velocidad de coche: " + miCoche.getVelocidad() );
			}
		});
		bGiraIzq.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				miCoche.gira( +10 );
				// System.out.println( "Nueva direcci�n de coche: " + miCoche.getDireccionActual() );
			}
		});
		bGiraDer.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				miCoche.gira( -10 );
				// System.out.println( "Nueva direcci�n de coche: " + miCoche.getDireccionActual() );
			}
		});
		
		// A�adido para que tambi�n se gestione por teclado con el KeyListener
		pPrincipal.addKeyListener( new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP: {
						//miCoche.acelera( +5, 1 );
						botones [0] = true;
						break;
					}
					case KeyEvent.VK_DOWN: {
						//miCoche.acelera( -5, 1 );
						botones [1] = true;
						break;
					}
					case KeyEvent.VK_LEFT: {
						//miCoche.gira( +10 );
						botones [2] = true;
						break;
					}
					case KeyEvent.VK_RIGHT: {
						//miCoche.gira( -10 );
						botones [3] = true;
						break;
					}
				}
			}
		});
		
		// A�adido para que tambi�n se gestione por teclado con el KeyListener
				pPrincipal.addKeyListener( new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						switch (e.getKeyCode()) {
							case KeyEvent.VK_UP: {
								//miCoche.acelera( +5, 1 );
								double fuerzaAceleracionAdelante = miCoche.fuerzaAceleracionAdelante();
								MundoJuego.aplicarFuerza (fuerzaAceleracionAdelante ,miCoche);
								botones [0] = false;
								break;
							}
							case KeyEvent.VK_DOWN: {
								//miCoche.acelera( -5, 1 );
								double fuerzaAceleracionAtras = miCoche.fuerzaAceleracionAdelante();
								MundoJuego.aplicarFuerza (fuerzaAceleracionAtras ,miCoche);
								botones [1] = false;
								break;
							}
							case KeyEvent.VK_LEFT: {
								//miCoche.gira( +10 );
								botones [2] = false;
								break;
							}
							case KeyEvent.VK_RIGHT: {
								//miCoche.gira( -10 );
								botones [3] = false;
								break;
							}
						}
					}
				});
				
				
		pPrincipal.setFocusable(true);
		pPrincipal.requestFocus();
		pPrincipal.addFocusListener( new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pPrincipal.requestFocus();
			}
		});
		// Cierre del hilo al cierre de la ventana
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (miHilo!=null) miHilo.acaba();
			}
		});
	}
	
	/** Programa principal de la ventana de juego
	 * @param args
	 */
	public static void main(String[] args) {
		// Crea y visibiliza la ventana con el coche
		try {
			final VentanaJuego miVentana = new VentanaJuego();
			SwingUtilities.invokeAndWait( new Runnable() {
				@Override
				public void run() {
					miVentana.setVisible( true );
				}
			});
			miVentana.miMundo = new MundoJuego( miVentana.pPrincipal );
			miVentana.miMundo.creaCoche( 150, 100 );
			miVentana.miCoche = miVentana.miMundo.getCoche();
			miVentana.miCoche.setPiloto( "Fernando Alonso" );
			// Crea el hilo de movimiento del coche y lo lanza
			miVentana.miHilo = miVentana.new MiRunnable();  // Sintaxis de new para clase interna
			Thread nuevoHilo = new Thread( miVentana.miHilo );
			nuevoHilo.start();
		} catch (Exception e) {
			System.exit(1);  // Error anormal
		}
	}
	
	/** Clase interna para implementaci�n de bucle principal del juego como un hilo
	 * @author Andoni Egu�luz
	 * Facultad de Ingenier�a - Universidad de Deusto (2014)
	 */
	class MiRunnable implements Runnable {
		boolean sigo = true;
		double segundos;
		@Override
		public void run() {
			// Bucle principal forever hasta que se pare el juego...
			
			while (sigo) {
				
				// Mover coche
				miCoche.mueve( 0.040 );
				// Chequear choques
				// (se comprueba tanto X como Y porque podr�a a la vez chocar en las dos direcciones (esquinas)
				if (miMundo.hayChoqueHorizontal(miCoche)) // Espejo horizontal si choca en X
					miMundo.rebotaHorizontal(miCoche);
				if (miMundo.hayChoqueVertical(miCoche)) // Espejo vertical si choca en Y
					miMundo.rebotaVertical(miCoche);
				
				double fuerzaRoz= miMundo.calcFuerzaRozamiento(miCoche.getMasa(), miCoche.getCoefRztoSuelo(), miCoche.getCoefRztoAire(), miCoche.getVelocidad());
//				
				if (botones[0]==true){
					
					
					miMundo.calcAceleracionConFuerza(miCoche.fuerzaAceleracionAdelante(), miCoche.getMasa());
					miMundo.aplicarFuerza(miCoche.fuerzaAceleracionAdelante(), miCoche);
					
					
					
					//miCoche.acelera( +5, 1 );
				}
				
				if (botones[0]==false){
					
					
					//miMundo.calcAceleracionConFuerza(miCoche.fuerzaAceleracionAdelante(), miCoche.getMASA());
					miMundo.aplicarFuerza(fuerzaRoz, miCoche);
					
				}

				
				
				if (botones[1]==true){
					
					miMundo.calcAceleracionConFuerza(-miCoche.fuerzaAceleracionAtras(), miCoche.getMasa());
					miMundo.aplicarFuerza(-miCoche.fuerzaAceleracionAtras(), miCoche);
					
					//miCoche.acelera( -5, 1 );
				}
				
				if (botones[1]==false){
					
					//miMundo.calcAceleracionConFuerza(-miCoche.fuerzaAceleracionAtras(), miCoche.getMASA());
					miMundo.aplicarFuerza(fuerzaRoz, miCoche);
					
				}
				if (botones[2]==true){
					miCoche.gira( +10 );
				}
				if (botones[3]==true){
					miCoche.gira( -10 );
				}

				
				if(segundos>=1.2){
				
					//Creamos la estrella
					Random r = new Random();

					
				}else{
					segundos=segundos+0.040;
				}
				
				
								
				// Dormir el hilo 40 milisegundos
				try {
					Thread.sleep( 40 );
				} catch (Exception e) {
				}
			}
		}
		/** Ordena al hilo detenerse en cuanto sea posible
		 */
		public void acaba() {
			sigo = false;
		}
	};
	
}
