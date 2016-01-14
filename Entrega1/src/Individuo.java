

import java.io.Serializable;

public class Individuo implements Serializable{

    protected int posicionX;
    protected int posicionY;
    protected int direccion;
    protected int inicialX;
    protected int inicialY;
    protected static final int DIRECCION_ARRIBA = Temporizador.ICONO_PROTAGONISTA_ARRIBA;
    protected static final int DIRECCION_ABAJO = Temporizador.ICONO_PROTAGONISTA_ABAJO;
    protected static final int DIRECCION_IZQUIERDA = Temporizador.ICONO_PROTAGONISTA_IZQUIERDA;
    protected static final int DIRECCION_DERECHA = Temporizador.ICONO_PROTAGONISTA_DERECHA;

    public Individuo(int posicionX, int posicionY, int direccion) {
        this.posicionX = posicionX;
        this.inicialX =posicionX;
        this.posicionY = posicionY;
        this.inicialY = posicionY;
        this.direccion = direccion;
    }

    public void situarInicio() {
        posicionX = inicialX;
        posicionY = inicialY;
    }
  
    public boolean coincide(Individuo otro) {
        return otro.getPosicionX() == posicionX && otro.getPosicionY() == posicionY;
    }

    public boolean coincide(int x, int y) {
        return x == posicionX && y == posicionY;
    }

    public boolean esAdyacente(int x, int y) {
    	return coincide(x,y-1)||coincide(x,y+1)||coincide(x-1,y)||coincide(x+1,y);
    }

    public int getPosicionX() {
        return posicionX;
    }
   
    public int getPosicionY() {
        return posicionY;
    }

    public int getDireccion() {
        return direccion;
    }

    public void muevete(Casilla[][] casillas) {
        switch(direccion) {
            case DIRECCION_ARRIBA:
                if(casillas[posicionY-1][posicionX].esPisable()) {
                    posicionY = posicionY - 1;
                }
                break;
            case DIRECCION_ABAJO:
                if(casillas[posicionY+1][posicionX].esPisable()) {
                    posicionY = posicionY + 1;
                }
                break;
            case DIRECCION_IZQUIERDA:
                if(casillas[posicionY][posicionX-1].esPisable()) {
                    posicionX = posicionX - 1;
                }
                break;
            case DIRECCION_DERECHA:
                if(casillas[posicionY][posicionX+1].esPisable()) {
                    posicionX = posicionX + 1;
                }
                break;
        }
    }
}
