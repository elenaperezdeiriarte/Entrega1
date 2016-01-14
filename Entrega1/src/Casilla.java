
import java.io.Serializable;


public class Casilla implements Serializable {
    public static final int TIPO_VACIA = Temporizador.ICONO_VACIA;
    public static final int TIPO_MURO = Temporizador.ICONO_MURO;
    public static final int TIPO_PUNTO = Temporizador.ICONO_PUNTO;
    public static final int TIPO_GUARIDA = Temporizador.ICONO_GUARIDA;

    private int tipo;  
    private boolean pisable;
    
    public Casilla(int tipo) {
        this.tipo = tipo;
        pisable = (tipo != TIPO_MURO && tipo != TIPO_GUARIDA);
    }

    public boolean esPisable() {
        return pisable;
    }

    public boolean esMuro() {
        return tipo == TIPO_MURO;
    }

    public boolean esVacia() {
        return tipo == TIPO_VACIA;
    }

    public boolean esPunto() {
        return tipo == TIPO_PUNTO;
    }
   
    
    public boolean esGuarida() {
        return tipo == TIPO_GUARIDA;
    }
    
    public void setPisable(boolean pisable) {
        this.pisable = pisable;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public int getTipo() {
        return tipo;
    }
}
