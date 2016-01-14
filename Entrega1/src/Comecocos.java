

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.swing.JFrame;


public class Comecocos extends Frame {
	private static final long serialVersionUID = 1L;
	private static final int PIXELSCUADRADO = 15;
    private static final int PIXELSPUNTO = 2;
    private static final int BORDE = 25;
    private static final int ANCHODERECHA = (PIXELSCUADRADO + 1) * 5;
    private int altoFrame;
    private int anchoFrame;
    private int alto;
    private int ancho;
    public int[][] tablero;
    public int puntos;
    private Tablero tableroFisico;


    private static final int COLOR_ROJO = 16520726;
    private static final int COLOR_VERDE = 16776960;
    private static final int COLOR_AZUL = -16776961;
    private static final int COLOR_NARANJA = 16746696;
    private static final int COLOR_AMARILLO = 16520830;
    private static final int COLOR_CYAN = 1504764;
    private static final int COLOR_NEGRO = -16777216;
    private static final int COLOR_BLANCO = -1;


    public Comecocos(int ancho, int alto, int intervalo)
    {	    
        this.ancho = ancho;
        this.alto = alto;
        tablero = new int[alto][ancho];
        anchoFrame = ancho * (PIXELSCUADRADO+1) + (2 * BORDE) + ANCHODERECHA;
        altoFrame = alto * (PIXELSCUADRADO+1) + (2 * BORDE);
        setSize (anchoFrame, altoFrame);
        setTitle("Comecocos");
        Comienzo.comecocos = this;
        Comienzo.intervalo = intervalo;
        Comienzo rpa = new Comienzo();
        tableroFisico = rpa.getTablero();
        addKeyListener (new TeclaPulsada(rpa));
        rpa.start();
        this.setLocationRelativeTo(null);
        
   }

    public void update (Graphics g)  
    {
        Image buffer = createImage (anchoFrame, altoFrame);
        Graphics sg = buffer.getGraphics();
        sg.clearRect(0, 0, anchoFrame, altoFrame);        
        pintarTablero(sg);

        if(tableroFisico.juegoGanado() || tableroFisico.juegoPerdido()) {
        	//pintarPuntos(sg);
        	Inicio inicio = new Inicio();
    		inicio.setVisible(true);
    		
    		int puntos = tableroFisico.getPuntos();
    		String nombre = BD.nombreJugador;
    		
    		actualizarPuntos(nombre, puntos);
        } 
        g.drawImage (buffer, 0, 0, this);
    }
    
    public boolean actualizarPuntos (String nombre, int puntos)
    {
    	BD.conexion();
		
		boolean act;
		int record = BD.puntuacionJugador(nombre);
		
		if (puntos > record) {
			BD.actualizar(nombre, puntos);
			act= true;
		}
		else
			act = false;
		BD.close();
		
		return act;
		
    }

    public void pintarTablero(Graphics g)
    {

        g.fillRect(BORDE - 2, BORDE - 2, (PIXELSCUADRADO+1)* (ancho) + 3, (PIXELSCUADRADO+1) * (alto) + 3);
      
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                int tipoCasilla = tablero[i][j];
                switch(tipoCasilla) {
                    // Pinta la casilla vacía
                    case Temporizador.ICONO_VACIA:
                        g.setColor(new Color(COLOR_NEGRO));
                        g.fillRect(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO, PIXELSCUADRADO);
                        break;
                    // Pinta un muro
                    case Temporizador.ICONO_MURO:
                        g.setColor(new Color(COLOR_NARANJA));
                        g.fillRect(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO, PIXELSCUADRADO);
                        break;
                    case Temporizador.ICONO_GUARIDA:
                        g.setColor(new Color(COLOR_VERDE));
                        g.fillRect(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO, PIXELSCUADRADO);
                        break;                
                    // Pinta un punto
                    case Temporizador.ICONO_PUNTO:
                        g.setColor(new Color(COLOR_BLANCO));
                        g.fillRect(BORDE+(PIXELSCUADRADO+1)*j+((PIXELSCUADRADO-PIXELSPUNTO)/2), BORDE+(PIXELSCUADRADO+1)*i+((PIXELSCUADRADO-PIXELSPUNTO)/2), PIXELSPUNTO, PIXELSPUNTO);
                        break;                        
                    case Temporizador.ICONO_PROTAGONISTA_ARRIBA:
                        g.setColor(new Color(COLOR_AMARILLO));
                        g.fillArc(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO-2, PIXELSCUADRADO-2, 120, 300);
                        break;
                    case Temporizador.ICONO_PROTAGONISTA_ABAJO:
                        g.setColor(new Color(COLOR_AMARILLO));
                        g.fillArc(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO-2, PIXELSCUADRADO-2, 300, 300);
                        break;
                    case Temporizador.ICONO_PROTAGONISTA_IZQUIERDA:
                        g.setColor(new Color(COLOR_AMARILLO));
                        g.fillArc(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO-2, PIXELSCUADRADO-2, 210, 300);
                        break;
                    case Temporizador.ICONO_PROTAGONISTA_DERECHA:
                        g.setColor(new Color(COLOR_AMARILLO));
                        g.fillArc(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO-2, PIXELSCUADRADO-2, 30, 300);
                        break;
                    case Temporizador.ICONO_ENEMIGO_VERDE:
                        g.setColor(new Color(COLOR_VERDE));
                        // Figura
                        g.fillArc(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO-2, PIXELSCUADRADO-2, 0, 180);
                        g.fillRect(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)-1, PIXELSCUADRADO, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/3), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/3), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        // Ojos
                        g.setColor(new Color(COLOR_BLANCO));
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/4), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4), PIXELSCUADRADO/5, PIXELSCUADRADO/4);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/4), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4), PIXELSCUADRADO/5, PIXELSCUADRADO/4);
                        g.setColor(new Color(COLOR_NEGRO));
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/4)+PIXELSCUADRADO/20, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4)+PIXELSCUADRADO/8, PIXELSCUADRADO/10, PIXELSCUADRADO/8);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/4)+PIXELSCUADRADO/20, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4)+PIXELSCUADRADO/8, PIXELSCUADRADO/10, PIXELSCUADRADO/8);
                        break;
                    case Temporizador.ICONO_ENEMIGO_AZUL:
                        g.setColor(new Color(COLOR_AZUL));
                        // Figura
                        g.fillArc(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO-2, PIXELSCUADRADO-2, 0, 180);
                        g.fillRect(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)-1, PIXELSCUADRADO, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/3), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/3), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        // Ojos
                        g.setColor(new Color(COLOR_BLANCO));
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/4), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4), PIXELSCUADRADO/5, PIXELSCUADRADO/4);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/4), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4), PIXELSCUADRADO/5, PIXELSCUADRADO/4);
                        g.setColor(new Color(COLOR_NEGRO));
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/4)+PIXELSCUADRADO/20, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4)+PIXELSCUADRADO/8, PIXELSCUADRADO/10, PIXELSCUADRADO/8);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/4)+PIXELSCUADRADO/20, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4)+PIXELSCUADRADO/8, PIXELSCUADRADO/10, PIXELSCUADRADO/8);
                        break;
                    case Temporizador.ICONO_ENEMIGO_ROJO:
                        g.setColor(new Color(COLOR_ROJO));
                        // Figura
                        g.fillArc(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO-2, PIXELSCUADRADO-2, 0, 180);
                        g.fillRect(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)-1, PIXELSCUADRADO, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/3), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/3), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        // Ojos
                        g.setColor(new Color(COLOR_BLANCO));
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/4), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4), PIXELSCUADRADO/5, PIXELSCUADRADO/4);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/4), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4), PIXELSCUADRADO/5, PIXELSCUADRADO/4);
                        g.setColor(new Color(COLOR_NEGRO));
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/4)+PIXELSCUADRADO/20, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4)+PIXELSCUADRADO/8, PIXELSCUADRADO/10, PIXELSCUADRADO/8);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/4)+PIXELSCUADRADO/20, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4)+PIXELSCUADRADO/8, PIXELSCUADRADO/10, PIXELSCUADRADO/8);
                        break;
                    case Temporizador.ICONO_ENEMIGO_CYAN:
                        g.setColor(new Color(COLOR_CYAN));
                        // Figura
                        g.fillArc(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i, PIXELSCUADRADO-2, PIXELSCUADRADO-2, 0, 180);
                        g.fillRect(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)-1, PIXELSCUADRADO, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/3), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/3), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/2)+(PIXELSCUADRADO/6), PIXELSCUADRADO/3, PIXELSCUADRADO/3);
                        // Ojos
                        g.setColor(new Color(COLOR_BLANCO));
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/4), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4), PIXELSCUADRADO/5, PIXELSCUADRADO/4);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/4), BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4), PIXELSCUADRADO/5, PIXELSCUADRADO/4);
                        g.setColor(new Color(COLOR_NEGRO));
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(PIXELSCUADRADO/4)+PIXELSCUADRADO/20, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4)+PIXELSCUADRADO/8, PIXELSCUADRADO/10, PIXELSCUADRADO/8);
                        g.fillOval(BORDE+(PIXELSCUADRADO+1)*j+(2*PIXELSCUADRADO/4)+PIXELSCUADRADO/20, BORDE+(PIXELSCUADRADO+1)*i+(PIXELSCUADRADO/4)+PIXELSCUADRADO/8, PIXELSCUADRADO/10, PIXELSCUADRADO/8);
                        break;

                }
            }
        }

        // Puntos
        g.setColor(Color.black);
        g.fillRect(BORDE + (PIXELSCUADRADO+1)* (ancho +1) - 5, BORDE+ (PIXELSCUADRADO+1)* (alto - 3) + 7,
                ANCHODERECHA - 2, PIXELSCUADRADO);
        g.setColor(Color.white);
        g.drawString("Puntos: " + tableroFisico.getPuntos(), BORDE+ (PIXELSCUADRADO+1)* (ancho +1) , BORDE+ (PIXELSCUADRADO+1)* (alto - 2));

        //Vidas
        g.setColor(Color.black);
        g.fillRect(BORDE + (PIXELSCUADRADO+1)* (ancho +1) - 5, BORDE+ (PIXELSCUADRADO+1)* (alto - 5) + 7,
                ANCHODERECHA - 2, PIXELSCUADRADO);
        g.setColor(Color.white);
        g.drawString("Vidas: " + tableroFisico.getVidas(), BORDE+ (PIXELSCUADRADO+1)* (ancho +1) , BORDE+ (PIXELSCUADRADO+1)* (alto - 4));        
    
    }

    private class TeclaPulsada extends KeyAdapter {
        private Temporizador t;
        public TeclaPulsada(Temporizador t) {
            this.t = t;
        }

        public void keyPressed (KeyEvent e) {
            char key = e.getKeyChar();
            t.teclaPulsada(String.valueOf(key));
        }
    }   
   
   
}


