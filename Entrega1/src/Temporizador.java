import java.awt.Color;


public abstract class Temporizador extends Thread {

    public static final int ICONO_GUARIDA = -1;
    public static final int ICONO_VACIA = 0;
    public static final int ICONO_MURO = 1;
    public static final int ICONO_PUNTO = 2;
    public static final int ICONO_PROTAGONISTA_ARRIBA = 3;
    public static final int ICONO_PROTAGONISTA_ABAJO = 4;
    public static final int ICONO_PROTAGONISTA_IZQUIERDA = 5;
    public static final int ICONO_PROTAGONISTA_DERECHA = 6;
    public static final int ICONO_ENEMIGO_VERDE = 7;
    public static final int ICONO_ENEMIGO_AZUL = 8;
    public static final int ICONO_ENEMIGO_ROJO = 9;
    public static final int ICONO_ENEMIGO_CYAN = 10;

  
    public static Comecocos comecocos;
    public static long intervalo;
    
    public void run ()
    {
        while (true) {
            comecocos.repaint();
            yield();           
            try {   	
            	if(Comienzo.getTablero().juegoPerdido() || Comienzo.getTablero().juegoGanado()) {
                	sleep(7000);
                	System.exit(-1);
            	}                
                sleep(intervalo);               
                siguienteTiempo();
            	
            } catch(InterruptedException e) { }            
        }
    }

 
    public void pintarCuadradoTablero(int x, int y, int tipoCasilla) {
         comecocos.tablero[x][y] = tipoCasilla;
    }

    public void establecerPuntos(int puntos) {
        comecocos.puntos = puntos;
    }

    public int obtenerPuntos() {
        return comecocos.puntos;
    }

    public void establecerTiempoDeEspera(long tiempo) {
        Temporizador.intervalo = tiempo;
    }

    public abstract void siguienteTiempo();

    public abstract void teclaPulsada(String tecla);
}
