

import java.io.*;

public class Comienzo extends Temporizador {
    public static int tiempoEspera = 500;
    public static boolean haBatidoRecord;
    public static int posicionRecord;
    
    private static Tablero tablero;
    private static int pantalla=1;
    
    public void inicioComecocos ()
    {
    	
        int roj = Enemigo.COLOR_ROJO;
        int azu = Enemigo.COLOR_AZUL;
        int cya = Enemigo.COLOR_CYAN;
        int ver = Enemigo.COLOR_VERDE;
        
        Enemigo[] e = new Enemigo[4];
        e[0] = new Enemigo(12, 12, Individuo.DIRECCION_ARRIBA, "Reud", roj);
        e[1] = new Enemigo(13, 12, Individuo.DIRECCION_ARRIBA, "Loki", azu);
        e[2] = new Enemigo(14, 12, Individuo.DIRECCION_ARRIBA, "Scio", cya);
        e[3] = new Enemigo(15, 12, Individuo.DIRECCION_ARRIBA, "Niel", ver);
        Lista enemigos = new Lista(e);
    
        Protagonista prota = new Protagonista(13, 21, Individuo.DIRECCION_IZQUIERDA);
        
        tablero = new Tablero(enemigos, prota);
        tablero.crearTableroInicial();       
        
      
	    Comecocos cc = new Comecocos(tablero.getAncho(), tablero.getAlto(),tiempoEspera);
        cc.setVisible(true);
		
    }

    public void siguienteTiempo() {
    	tablero.siguienteMovimiento(); 
       	Casilla[][] casillas = getTablero().getCasillas(); 
       	Enemigo[] e = tablero.getEnemigos().getEnemigos();
       	
       	for(int i=0; i< tablero.getAlto(); i++) {
       		for(int j=0; j<tablero.getAncho(); j++) {
       			int tipoCasilla = casillas[i][j].getTipo();
       			if(tablero.getProta().getPosicionX()==j && tablero.getProta().getPosicionY()==i) {
       				int prota = tablero.getProta().getDireccion();
       				pintarCuadradoTablero(i, j, prota);
       			}
                else {
                pintarCuadradoTablero(i, j, tipoCasilla);
                }
                for(int k = 0; k<e.length; k++) {
                    if(e[k].getPosicionX()==j && e[k].getPosicionY() == i) {
                    	int enemigo = e[k].getColorInt();
                    	pintarCuadradoTablero(i,j,enemigo);
                    }                	
                }    
            }
        }  
       
        establecerTiempoDeEspera(tiempoEspera);

    }

    public void teclaPulsada(String tecla) {
        tablero.getProta().cambiaDireccion(tecla);
    }
    
    public static Tablero getTablero(){
    	return tablero;
	}
}
